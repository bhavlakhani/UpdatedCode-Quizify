package com.stackroute.quizify.kafka.config;

import com.stackroute.quizify.dto.model.QuestionDTO;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {
    private String bootstrapServer;
    private Environment env;

    public KafkaProducerConfig(Environment env)
    {
        this.env = env;
        this.bootstrapServer = env.getProperty("kafka.bootstrap-server");
    }

    @Bean
    public ProducerFactory<String, QuestionDTO> producerFactory() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServer);
        configs.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return  new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    public KafkaTemplate<String, QuestionDTO> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
