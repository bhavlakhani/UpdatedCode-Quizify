package com.stackroute.quizify.kafka;

import com.stackroute.quizify.dto.mapper.UserMapper;
import com.stackroute.quizify.dto.model.UserDTO;
import com.stackroute.quizify.userregistrationservice.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer {

    @Value("${kafka.topic}")
    private  String topic;

    private User payload;


    private KafkaTemplate<String, UserDTO> kafkaTemplate;
    private UserMapper userMapper;
    private UserDTO userDTO;

    @Autowired
    public Producer(KafkaTemplate<String, UserDTO> kafkaTemplate, UserMapper userMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.userMapper = userMapper;
    }

    public UserDTO send(UserDTO payload) {
        kafkaTemplate.send("users", payload);
        log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        log.info("User Sent from User Registration Service : ");
        log.info(""+payload);
        return this.userDTO;
    }
}
