package com.stackroute.quizify.kafka;

import com.stackroute.quizify.dto.mapper.QuestionMapper;
import com.stackroute.quizify.dto.model.QuestionDTO;
import com.stackroute.quizify.questionmanager.domain.Question;
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
    private KafkaTemplate<String, QuestionDTO> kafkaTemplate;
    private QuestionMapper questionMapper;
    private QuestionDTO questionDTO;


    @Autowired
    public Producer(Environment env, KafkaTemplate<String, QuestionDTO> kafkaTemplate, QuestionMapper questionMapper)
    {
        this.env = env;
//        this.kafkaTopic = env.getProperty("kafka.topic");
        this.kafkaTopic = "questions";
        this.kafkaTemplate = kafkaTemplate;
        this.questionMapper = questionMapper;
    }

    public QuestionDTO send(Question payload) {
        this.questionDTO = this.questionMapper.questionToQuestionDTO(payload);
        kafkaTemplate.send(this.kafkaTopic, this.questionDTO);
        logger.info("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        logger.info("Sending Questions from Question-manager-Service : ");
        logger.info(""+this.questionDTO);
        return this.questionDTO;
    }
}
