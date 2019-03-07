package com.stackroute.quizify.kafka;

import com.stackroute.quizify.dto.mapper.GameMapper;
import com.stackroute.quizify.dto.model.GameDTO;
import com.stackroute.quizify.gamemanager.domain.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class Consumer {
    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    private Environment env;
    private String kafkaTopic;
    private String consumerId;
    private String bootstrapServer;
    private GameMapper gameMapper;
    private Game game;


    @Autowired
    public Consumer(Environment env, GameMapper gameMapper)
    {
        this.env = env;
        this.kafkaTopic = env.getProperty("kafka.topic");
        this.kafkaTopic = "game";
        this.consumerId = env.getProperty("kafka.group-id");
        this.bootstrapServer = env.getProperty("kafka.bootstrap-server");
        this.gameMapper = gameMapper;

    }

    @KafkaListener(topics = "game", groupId = "game-self-consumers", containerFactory = "kafkaListenerContainerFactory")
    public void receive(@Payload GameDTO payload) {
        logger.info("-----------------------------------------------------------------------------------------");
        logger.info("Game Received by Game-Manager-Service: ");
        logger.info(""+payload);
        this.game = this.gameMapper.gameDTOToGame(payload);
    }

}
