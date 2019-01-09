package de.evoila.cf.autoscaler.kafka.producer;

import com.google.gson.Gson;
import de.evoila.cf.autoscaler.kafka.KafkaPropertiesBean;
import de.evoila.cf.autoscaler.kafka.model.BindingInformation;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * Created by reneschollmeyer, evoila on 16.10.18.
 */
@Service
@ConditionalOnBean(KafkaPropertiesBean.class)
public class KafkaJsonProducer {

    private KafkaPropertiesBean kafkaProperties;

    private Gson gson;

    Producer<String, String> producer;

    public KafkaJsonProducer(KafkaPropertiesBean kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
        this.gson = new Gson();
    }

    public void initializeKafkaProducer() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getHost() + ":" + kafkaProperties.getPort());
        properties.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 1000);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(properties);
    }

    public void produceKafkaMessage(String topic, BindingInformation bindingInformation) {
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, gson.toJson(bindingInformation));

        producer.send(record);
        producer.flush();
    }
}
