package de.evoila.cf.autoscaler.kafka.security;


import de.evoila.cf.autoscaler.kafka.KafkaPropertiesBean;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import sun.security.util.DerInputStream;
import sun.security.util.DerValue;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.util.Base64;

/**
 * Created by reneschollmeyer, evoila on 23.01.2019.
 */
@Service
@ConditionalOnProperty(prefix = "kafka", value = "secure", havingValue = "true")
public class CertificateHandler {

    private KafkaPropertiesBean kafkaPropertiesBean;

    public CertificateHandler(KafkaPropertiesBean kafkaPropertiesBean) {
        this.kafkaPropertiesBean = kafkaPropertiesBean;

        if(kafkaPropertiesBean.isSecure()) {
            try {
                Certificate caCert = loadCertificate(kafkaPropertiesBean.getCertificate());
                char[] keyStorePassword = kafkaPropertiesBean.getKeystorePassword().toCharArray();
                char[] trustStorePassword = kafkaPropertiesBean.getTruststorePassword().toCharArray();

                KeyStore keyStore = KeyStore.getInstance("jks");
                keyStore.load(null, keyStorePassword);
                keyStore.setCertificateEntry("CARoot", caCert);

                KeyStore trustStore = KeyStore.getInstance("jks");
                trustStore.load(null, trustStorePassword);
                trustStore.setCertificateEntry("CARoot", caCert);

                FileOutputStream fos = new FileOutputStream( System.getProperty("java.io.tmpdir") + "/client.keystore.jks");
                keyStore.store(fos, keyStorePassword);
                fos.close();

                fos = new FileOutputStream( System.getProperty("java.io.tmpdir") + "/client.truststore.jks");
                trustStore.store(fos, trustStorePassword);
                fos.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Certificate loadCertificate(String certificatePem) throws IOException, GeneralSecurityException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X509");
        final byte[] content = readPemContent(certificatePem);
        return certificateFactory.generateCertificate(new ByteArrayInputStream(content));
    }

    public PrivateKey loadPrivateKey(String privateKeyPem) throws IOException, GeneralSecurityException {
        return pemLoadPrivateKeyPkcs1OrPkcs8Encoded(privateKeyPem);
    }

    private byte[] readPemContent(String pem) throws IOException {
        final byte[] content;
        try (PemReader pemReader = new PemReader(new StringReader(pem))) {
            final PemObject pemObject = pemReader.readPemObject();
            content = pemObject.getContent();
        }
        return content;
    }

    private static PrivateKey pemLoadPrivateKeyPkcs1OrPkcs8Encoded(String privateKeyPem) throws GeneralSecurityException, IOException {
        // PKCS#8 format
        final String PEM_PRIVATE_START = "-----BEGIN PRIVATE KEY-----";
        final String PEM_PRIVATE_END = "-----END PRIVATE KEY-----";

        // PKCS#1 format
        final String PEM_RSA_PRIVATE_START = "-----BEGIN RSA PRIVATE KEY-----";
        final String PEM_RSA_PRIVATE_END = "-----END RSA PRIVATE KEY-----";

        if (privateKeyPem.contains(PEM_PRIVATE_START)) { // PKCS#8 format
            privateKeyPem = privateKeyPem.replace(PEM_PRIVATE_START, "").replace(PEM_PRIVATE_END, "");
            privateKeyPem = privateKeyPem.replaceAll("\\s", "");

            byte[] pkcs8EncodedKey = Base64.getDecoder().decode(privateKeyPem);

            KeyFactory factory = KeyFactory.getInstance("RSA");
            return factory.generatePrivate(new PKCS8EncodedKeySpec(pkcs8EncodedKey));

        } else if (privateKeyPem.contains(PEM_RSA_PRIVATE_START)) {  // PKCS#1 format

            privateKeyPem = privateKeyPem.replace(PEM_RSA_PRIVATE_START, "").replace(PEM_RSA_PRIVATE_END, "");
            privateKeyPem = privateKeyPem.replaceAll("\\s", "");

            DerInputStream derReader = new DerInputStream(Base64.getDecoder().decode(privateKeyPem));

            DerValue[] seq = derReader.getSequence(0);

            if (seq.length < 9) {
                throw new GeneralSecurityException("Could not parse a PKCS1 private key.");
            }

            // skip version seq[0];
            BigInteger modulus = seq[1].getBigInteger();
            BigInteger publicExp = seq[2].getBigInteger();
            BigInteger privateExp = seq[3].getBigInteger();
            BigInteger prime1 = seq[4].getBigInteger();
            BigInteger prime2 = seq[5].getBigInteger();
            BigInteger exp1 = seq[6].getBigInteger();
            BigInteger exp2 = seq[7].getBigInteger();
            BigInteger crtCoef = seq[8].getBigInteger();

            RSAPrivateCrtKeySpec keySpec = new RSAPrivateCrtKeySpec(modulus, publicExp, privateExp, prime1, prime2,
                    exp1, exp2, crtCoef);

            KeyFactory factory = KeyFactory.getInstance("RSA");

            return factory.generatePrivate(keySpec);
        }

        throw new GeneralSecurityException("Not supported format of a private key");
    }
}