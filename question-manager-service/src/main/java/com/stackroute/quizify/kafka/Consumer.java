package com.stackroute.quizify.kafka;

import com.stackroute.quizify.dto.mapper.QuestionMapper;
import com.stackroute.quizify.dto.model.QuestionDTO;
import com.stackroute.quizify.questionmanager.domain.Question;
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
    private QuestionMapper questionMapper;
    private Question question;


    @Autowired
    public Consumer(Environment env, QuestionMapper questionMapper)
    {
        this.env = env;
        this.kafkaTopic = env.getProperty("kafka.topic");
        this.consumerId = env.getProperty("kafka.group-id");
        this.bootstrapServer = env.getProperty("kafka.bootstrap-server");
        this.questionMapper = questionMapper;

    }


    @KafkaListener(topics = "questions", groupId = "questions-self-consumers", containerFactory = "kafkaListenerContainerFactory")
    public void receive(@Payload QuestionDTO payload) {
        this.question = this.questionMapper.questionDTOtoQuestion(payload);
        logger.info("------------------------------------------------------------------------------------------------");
        logger.info("Question Received by Question-Manager-Service : ");
        logger.info(""+this.question);

    }

}
