
package com.stackroute.quizify.kafka.configuration;

import com.stackroute.quizify.dto.model.GameDTO;
import com.stackroute.quizify.dto.model.SinglePlayerDTO;
import com.stackroute.quizify.dto.model.UserDTO;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Value("${kafka.bootstrap-server}")
    private String bootstrapServer;

    private String consumersId;

    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        Map<String, Object> config = new HashMap<>();

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServer);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,  JsonDeserializer.class);


        return new DefaultKafkaConsumerFactory<>(config);
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, GameDTO> gameConsumerFactory()
    {
        System.out.println("-----------------------------------------------------------");
        this.consumersId = "recommendation-game-consumer";
        Map<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServer);
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, this.consumersId);
        configs.put(JsonDeserializer.VALUE_DEFAULT_TYPE, GameDTO.class);
        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");

        return new DefaultKafkaConsumerFactory<>(configs);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, GameDTO> kafkaListenerGameContainerFactory ()
    {
        System.out.println("-----------------------------------------------------------------------");
        ConcurrentKafkaListenerContainerFactory<String, GameDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(gameConsumerFactory());

        return factory;
    }

    @Bean
    public ConsumerFactory<String, UserDTO> userConsumerFactory()
    {
        System.out.println("---------------------------------------------------");
        this.consumersId = "recommendation-user-consumer";
        System.out.println("-----------------"+this.consumersId);
        Map<String, Object> configs = new HashMap<>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServer);
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, this.consumersId);
        configs.put(JsonDeserializer.VALUE_DEFAULT_TYPE, UserDTO.class);
        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");

        return new DefaultKafkaConsumerFactory<>(configs);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, UserDTO> kafkaListenerUserContainerFactory ()
    {
        System.out.println("---------------------------------------------------------------------");
        ConcurrentKafkaListenerContainerFactory<String, UserDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(userConsumerFactory());

        return factory;
    }

//    @Bean
//    public ConsumerFactory<String, SinglePlayerDTO> singlePlayerConsumerFactory()
//    {
//        this.consumersId = "recommendation-single-player-consumer";
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServer);
//        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
//        configs.put(ConsumerConfig.GROUP_ID_CONFIG, this.consumersId);
//        configs.put(JsonDeserializer.VALUE_DEFAULT_TYPE, SinglePlayerDTO.class);
//        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
//        configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
//
//        return new DefaultKafkaConsumerFactory<>(configs);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, SinglePlayerDTO> kafkaListenerSinglePlayerContainerFactory ()
//    {
//        ConcurrentKafkaListenerContainerFactory<String, SinglePlayerDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(singlePlayerConsumerFactory());
//
//        return factory;
//    }

}

