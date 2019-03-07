package com.stackroute.quizify.kafka;

import com.stackroute.quizify.dto.mapper.GameMapper;
import com.stackroute.quizify.dto.mapper.QuestionMapper;
import com.stackroute.quizify.dto.model.GameDTO;
import com.stackroute.quizify.gamemanager.domain.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private Environment env;
    private String kafkaTopic;
    private Logger logger = LoggerFactory.getLogger(Producer.class);
    private KafkaTemplate<String, GameDTO> kafkaTemplate;
    private GameMapper gameMapper;
    private GameDTO gameDTO;

    @Autowired
    public Producer(Environment env, KafkaTemplate<String, GameDTO> kafkaTemplate, GameMapper gameMapper)
    {
        this.env = env;
//        this.kafkaTopic = env.getProperty("kafka.topic");
        this.kafkaTopic = "game";
        this.kafkaTemplate = kafkaTemplate;
        this.gameMapper = gameMapper;
    }


    public GameDTO send(Game payload) {
        this.gameDTO = this.gameMapper.gameToGameDTO(payload);
        kafkaTemplate.send(this.kafkaTopic, this.gameDTO);
        logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info("Game Sent by Game-Manager-Service : ");
        logger.info(""+this.gameDTO);
        return this.gameDTO;
    }
}
