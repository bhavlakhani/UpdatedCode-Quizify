//package com.stackroute.quizify.kafka.configuration;
//
//import com.stackroute.quizify.kafka.domain.Game;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@EnableKafka
//public class KafkaConsumerConfig {
//
//    @Value("${kafka.bootstrap-server}")
//    private String bootstrapServer;
//
//    @Value("${kafka.group-id}")
//    private String consumersId;
//
//    @Bean
//    public ConsumerFactory<String, Game> consumerFactory()
//    {
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServer);
//        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        configs.put(ConsumerConfig.GROUP_ID_CONFIG, this.consumersId);
//        configs.put(JsonDeserializer.VALUE_DEFAULT_TYPE, Game.class);
//        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
//        configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
//
//        return new DefaultKafkaConsumerFactory<>(configs);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, Game> kafkaListenerContainerFactory ()
//    {
//        ConcurrentKafkaListenerContainerFactory<String, Game> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//
//        return factory;
//    }
//
//}
