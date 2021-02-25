package br.com.zup.transactions.config;

import br.com.zup.transactions.consumer.model.TransactionReceiver;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Value("${transactions.kafka.boot.server}")
    private String kafkaServer;

    @Value("${transactions.kafka.consumer.group.id}")
    private String kafkaGroupId;

    @Bean
    public ConsumerFactory<String, TransactionReceiver> consumerConfig() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaGroupId);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), getDeserializer());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, TransactionReceiver>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, TransactionReceiver> listener = new ConcurrentKafkaListenerContainerFactory<>();
        listener.setConsumerFactory(consumerConfig());
        return listener;
    }

    public JsonDeserializer<TransactionReceiver> getDeserializer() {
        JsonDeserializer<TransactionReceiver> json = new JsonDeserializer<>(TransactionReceiver.class, false);
        json.addTrustedPackages("*");

        return json;
    }

}
