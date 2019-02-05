package de.evoila.cf.autoscaler.kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * A bean for storing properties dedicated to Kafka.
 * Spring fills the fields at the start of the Autoscaler with values out of the properties file.
 * @author Marius Berger
 *
 */
@Configuration
@ConfigurationProperties(prefix = "kafka")
public class KafkaPropertiesBean {

	/**
	 * IP or URL of the Kafka host
	 */
	private String host;

	/**
	 * Port to connect to Kafka
	 */
	private int port;

	/**
	 * Topic for HTTP metrics
	 */
	private String metricHttpTopic;

	/**
	 * Topic for Container metrics
	 */
	private String metricContainerTopic;

	/**
	 * Topic for Application metrics
	 */
	private String metricApplicationTopic;

	/**
	 * Topic for Scaling logs
	 */
	private String scalingTopic;

	/**
	 * Topic for predictions
	 */
	private String predicTopic;

	/**
	 * Topic for binding notifications
	 */
	private String bindingTopic;

	/**
	 * Topic for log messages
	 */
	private String logMessageTopic;

	/**
	 * Count of Container consumers to start
	 */
	private int containerConsumerCount;

	/**
	 * Count of HTTP consumers to start
	 */
	private int requestConsumerCount;

	/**
	 * Id of the group for producers
	 */
	private String producerGroupId;

	/**
	 * Id of the group for Container consumers
	 */
	private String containerConsumerGroupId;

	/**
	 * Id of the group for HTTP consumers
	 */
	private String httpConsumerGroupId;

	/**
	 * Id of the group for prediction consumers
	 */
	private String predictionConsumerGroupId;

	/**
	 * Whether or not the Kafka producer should be started
	 */
	private boolean producerEnabled;

	/**
	 * Whether or not the Kafka consumer should be started
	 */
	private boolean consumerEnabled;

	/**
	 * Whether kafka is secured or not
	 */
	private boolean secure;

	/**
	 * Ca Certificate from Kafka Server
	 */
	private String certificate;

	/**
	 * Password for the keystore that will be created
	 */
	private String keystorePassword;

	/**
	 * Password for the truststore that will be created
	 */
	private String truststorePassword;

	/**
	 * Security protocol for communication with kafka
	 */
	private String securityProtocol;

	/**
	 * Username for SASL connection with kafka
	 */
	private String saslClientUsername;

	/**
	 * Password for SASL connection with kafka
	 */
	private String saslClientPassword;

	/**
	 * Constructor for Spring to inject the bean.
	 */
	public KafkaPropertiesBean() { }


	public String getHost() {
		return host;
	}

	public int getPort() {
		return port;
	}

	public String getPredicTopic() {
		return predicTopic;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setPredicTopic(String predicTopic) {
		this.predicTopic = predicTopic;
	}

	public String getMetricHttpTopic() {
		return metricHttpTopic;
	}

	public void setMetricHttpTopic(String metricHttpTopic) {
		this.metricHttpTopic = metricHttpTopic;
	}

	public String getMetricContainerTopic() {
		return metricContainerTopic;
	}

	public void setMetricContainerTopic(String metricContainerTopic) {
		this.metricContainerTopic = metricContainerTopic;
	}

	public String getMetricApplicationTopic() {
		return metricApplicationTopic;
	}

	public void setMetricApplicationTopic(String metricApplicationTopic) {
		this.metricApplicationTopic = metricApplicationTopic;
	}

	public String getScalingTopic() {
		return scalingTopic;
	}

	public void setScalingTopic(String scalingTopic) {
		this.scalingTopic = scalingTopic;
	}

	public String getBindingTopic() {
		return bindingTopic;
	}

	public void setBindingTopic(String bindingTopic) {
		this.bindingTopic = bindingTopic;
	}

	public String getLogMessageTopic() { return logMessageTopic; }

	public void setLogMessageTopic(String logMessageTopic) {
		this.logMessageTopic = logMessageTopic;
	}

	public int getContainerConsumerCount() {
		return containerConsumerCount;
	}

	public void setContainerConsumerCount(int containerConsumerCount) {
		this.containerConsumerCount = containerConsumerCount;
	}

	public int getRequestConsumerCount() {
		return requestConsumerCount;
	}

	public void setRequestConsumerCount(int requestConsumerCount) {
		this.requestConsumerCount = requestConsumerCount;
	}

	public String getProducerGroupId() {
		return producerGroupId;
	}

	public void setProducerGroupId(String producerGroupId) {
		this.producerGroupId = producerGroupId;
	}


	public String getContainerConsumerGroupId() {
		return containerConsumerGroupId;
	}

	public void setContainerConsumerGroupId(String containerConsumerGroupId) {
		this.containerConsumerGroupId = containerConsumerGroupId;
	}

	public String getHttpConsumerGroupId() {
		return httpConsumerGroupId;
	}

	public void setHttpConsumerGroupId(String httpConsumerGroupId) {
		this.httpConsumerGroupId = httpConsumerGroupId;
	}

	public String getPredictionConsumerGroupId() {
		return predictionConsumerGroupId;
	}

	public void setPredictionConsumerGroupId(String predictionConsumerGroupId) {
		this.predictionConsumerGroupId = predictionConsumerGroupId;
	}

	public boolean isProducerEnabled() {
		return producerEnabled;
	}

	public void setProducerEnabled(boolean producerEnabled) {
		this.producerEnabled = producerEnabled;
	}

	public boolean isConsumerEnabled() {
		return consumerEnabled;
	}

	public void setConsumerEnabled(boolean consumerEnabled) {
		this.consumerEnabled = consumerEnabled;
	}

	public boolean isSecure() {
		return secure;
	}

	public void setSecure(boolean secure) {
		this.secure = secure;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getKeystorePassword() {
		return keystorePassword;
	}

	public void setKeystorePassword(String keystorePassword) {
		this.keystorePassword = keystorePassword;
	}

	public String getTruststorePassword() {
		return truststorePassword;
	}

	public void setTruststorePassword(String truststorePassword) {
		this.truststorePassword = truststorePassword;
	}

	public String getSecurityProtocol() {
		return securityProtocol;
	}

	public void setSecurityProtocol(String securityProtocol) {
		this.securityProtocol = securityProtocol;
	}

	public String getSaslClientUsername() {
		return saslClientUsername;
	}

	public void setSaslClientUsername(String saslClientUsername) {
		this.saslClientUsername = saslClientUsername;
	}

	public String getSaslClientPassword() {
		return saslClientPassword;
	}

	public void setSaslClientPassword(String saslClientPassword) {
		this.saslClientPassword = saslClientPassword;
	}
}