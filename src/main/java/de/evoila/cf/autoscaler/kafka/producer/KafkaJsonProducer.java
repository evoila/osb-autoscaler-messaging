package de.evoila.cf.autoscaler.kafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.evoila.cf.autoscaler.kafka.KafkaPropertiesBean;
import de.evoila.cf.autoscaler.kafka.messages.ApplicationMetric;
import de.evoila.cf.autoscaler.kafka.messages.ContainerMetric;
import de.evoila.cf.autoscaler.kafka.messages.HttpMetric;
import de.evoila.cf.autoscaler.kafka.messages.ScalingLog;
import de.evoila.cf.autoscaler.kafka.model.BindingInformation;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * Created by reneschollmeyer, evoila on 16.10.18.
 */
@Service
@ConditionalOnProperty(value = "kafka.producerEnabled", havingValue = "true")
public class KafkaJsonProducer {

    private static Logger log = LoggerFactory.getLogger(KafkaJsonProducer.class);

    private KafkaPropertiesBean kafkaProperties;

    private ObjectMapper objectMapper;

    private Producer<String, String> producer;

    public KafkaJsonProducer(KafkaPropertiesBean kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
        objectMapper = new ObjectMapper();

        Properties properties = new Properties();
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getHost() + ":" + kafkaProperties.getPort());
        properties.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 1000);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getProducerGroupId() == null ? "default-producer-group-id" : kafkaProperties.getProducerGroupId());

        producer = new KafkaProducer<>(properties);
    }

    /**
     * Publish a {@linkplain ScalingLog} on Kafka.
     * @param scalingLog {@linkplain ScalingLog} to publish
     */
    public void produceScalingLog(ScalingLog scalingLog) {
        produce(kafkaProperties.getScalingTopic(), scalingLog);
    }

    /**
     * Publish a {@linkplain HttpMetric} on Kafka on the given topic.
     * @param metric {@linkplain HttpMetric} to publish
     */
    public void produceHttpMetric(HttpMetric metric) {
        produce(kafkaProperties.getMetricHttpTopic(), metric);
    }

    /**
     * Publish a {@linkplain ContainerMetric} on Kafka.
     * @param containerMetric {@linkplain ContainerMetric} to publish
     */
    public void produceContainerMetric(ContainerMetric containerMetric) {
        produce(kafkaProperties.getMetricContainerTopic(), containerMetric);
    }

    /**
     * Publish a {@linkplain ApplicationMetric} on Kafka.
     * @param applicationMetric {@linkplain ApplicationMetric} to publish
     */
    public void produceApplicationMetric(ApplicationMetric applicationMetric) {
        produce(kafkaProperties.getMetricApplicationTopic(), applicationMetric);
    }

    /**
     * Publish a {@linkplain BindingInformation} on Kafka.
     * @param bindingInformation {@linkplain BindingInformation} to publish
     */
    public void produceBindingInformation(BindingInformation bindingInformation) {
        produce(kafkaProperties.getBindingTopic(), bindingInformation);
    }

    /**
     * Serializes an object to JSON and then calls {@linkplain #produceString(String, String)}.
     * @param topic Kafka topic to publish on
     * @param jacksonSerializableObject object to serialize to JSON
     */
    public void produce(String topic, Object jacksonSerializableObject) {
        try {
            String json = objectMapper.writeValueAsString(jacksonSerializableObject);
            produceString(topic, json);
        } catch (JsonProcessingException ex) {
            log.error("Failed to generate json from "+jacksonSerializableObject.getClass().getSimpleName()+" object.", ex);
        }
    }

    /**
     * Publishs a message in the String format on the given topic.
     * Other methods in this class use this to publish JSON messages.
     * @param topic Kafka topic to publish on
     * @param message message to publish
     */
    public void produceString(String topic, String message) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);
        producer.send(record);
    }
}
