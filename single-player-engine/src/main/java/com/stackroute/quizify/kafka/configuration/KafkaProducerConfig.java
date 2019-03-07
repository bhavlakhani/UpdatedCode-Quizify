//package com.stackroute.quizify.kafka.configuration;
//
//import com.stackroute.quizify.kafka.domain.SinglePlayer;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaProducerConfig {
//    @Value("${kafka.bootstrap-server}")
//    private String bootstrapServer;
//
//    @Bean
//    public ProducerFactory<String, SinglePlayer> producerFactory() {
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
//        configs.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
//        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//
//        return  new DefaultKafkaProducerFactory<>(configs);
//    }
//
//    @Bean
//    public KafkaTemplate<String, SinglePlayer> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//}
