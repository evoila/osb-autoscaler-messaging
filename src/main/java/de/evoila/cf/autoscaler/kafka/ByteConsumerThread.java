package de.evoila.cf.autoscaler.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * A Thread subscribing to a Kafka topic and returning messages in byte form to its consumer.
 * @author Marius Berger
 *
 */
public class ByteConsumerThread extends Thread{

    private static final String SECURITY_PROTOCOL = "security.protocol";

	/** 
	 * Serial number for thread naming purposes.
	 */
    private static int serial = 1;

    /**
     * Logger of this class.
     */
	private Logger log = LoggerFactory.getLogger(ByteConsumerThread.class);
	
	/**
	 * Topic to subscribe to.
	 */
	private String topicName;
    /**
     * Id of the group to join.
     */
	private String groupId;
    /**
     * IP or URL of the host plus the port.
     */
    private String host;

    /**
     * Consumer of incoming messages. For every message, the consumers consume method will be called.
     * @see AutoScalerConsumer
     */
    private AutoScalerConsumer consumer;
    /**
     * Underlying KafkaConsumer for connection to Kafka.
     */
    private KafkaConsumer<String,byte[]> kafkaConsumer;

    /**
     * Config containing kafka information
     */
    private KafkaPropertiesBean kafkaPropertiesBean;
    
    /**
     * Constructor with all necessary fields.
     * @param topicName {@linkplain #topicName}
     * @param groupId {@linkplain #groupId}
     * @param consumer {@linkplain #consumer}
     */
    public ByteConsumerThread(String topicName, String groupId, AutoScalerConsumer consumer, KafkaPropertiesBean kafkaPropertiesBean){
    	super("CThr "+(serial++)+" - "+consumer.getType());
    	this.kafkaPropertiesBean = kafkaPropertiesBean;
        this.topicName = topicName;
        this.groupId = groupId;
        this.host = kafkaPropertiesBean.getHost() +":"+ kafkaPropertiesBean.getPort();
        this.consumer = consumer;
    }
    
    /**
     * Create a Kafka Consumer and start polling for messages until a wake up call on the Kafka Consumer is made.
     * @see KafkaConsumer
     */
    public void run() {
        Properties configProperties = new Properties();
        configProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, host);
        configProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        configProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        configProperties.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);

        if(kafkaPropertiesBean.isSecure()) {
            String jaasTemplate = "org.apache.kafka.common.security.scram.ScramLoginModule required username=\"%s\" password=\"%s\";";
            String jaasCfg = String.format(jaasTemplate, kafkaPropertiesBean.getSaslClientUsername(), kafkaPropertiesBean.getSaslClientPassword());

            configProperties.put(SECURITY_PROTOCOL, kafkaPropertiesBean.getSecurityProtocol());
            configProperties.put(SaslConfigs.SASL_MECHANISM, "SCRAM-SHA-256");
            configProperties.put(SaslConfigs.SASL_JAAS_CONFIG, jaasCfg);
            configProperties.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, "client.truststore.jks");
            configProperties.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, kafkaPropertiesBean.getTrustStorePassword());
            configProperties.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, "client.keystore.jks");
            configProperties.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, kafkaPropertiesBean.getKeyStorePassword());
            // This one is needed to skip verification of self signed certificates
            configProperties.put(SslConfigs.SSL_ENDPOINT_IDENTIFICATION_ALGORITHM_CONFIG, "");
        }

        kafkaConsumer = new KafkaConsumer<>(configProperties);
        kafkaConsumer.subscribe(Arrays.asList(topicName));

        try {
            while (true) {
                ConsumerRecords<String, byte[]> records = kafkaConsumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, byte[]> record : records) {
                	consumer.consume(record.value());
                }
            }
        } catch(WakeupException ex) {
        } finally {
            kafkaConsumer.close();
            log.info("Closed the KafkaConsumer "+Thread.currentThread().getName()+".");
        }
    }
    
    /**
     * Returns the underlying Kafka Consumer mainly for waking it up.
     * @return Kafka Consumer of this thread
     * @see KafkaConsumer
     */
    public KafkaConsumer<String,byte[]> getKafkaConsumer(){
       return this.kafkaConsumer;
    }
}

