//package com.stackroute.quizify.kafka;
//
//import com.stackroute.quizify.dto.mapper.UserMapper;
//import com.stackroute.quizify.dto.model.UserDTO;
//import com.stackroute.quizify.userregistrationservice.domain.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Consumer {
//
//    private Logger logger = LoggerFactory.getLogger(Producer.class);
//    private UserMapper userMapper;
//    private User user;
//
//    @Autowired
//    public Consumer(UserMapper userMapper)
//    {
//        this.userMapper = userMapper;
//    }
//
//    @KafkaListener(topics = "user", groupId = "user-self-consumers", containerFactory = "kafkaListenerContainerFactory")
//    public void receive(@Payload UserDTO payload) {
//        this.user = this.userMapper.userDTOToUser(payload);
//        logger.info("------------------------------------------------------------------------------------------------");
//        logger.info("User Received At User Registration Service : "+this.user);
//    }
//
//}
