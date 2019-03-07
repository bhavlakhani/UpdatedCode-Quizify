//package com.stackroute.quizify.kafka;
//
//import com.stackroute.quizify.userauthentication.domain.User;
//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Component
//public class Producer {
//
//    @Value("${kafka.topic}")
//    private String topic;
//
//    private User payload;
//
//
//    private KafkaTemplate<String, User> kafkaTemplate;
//
//    public User getPayload()
//    {
//        return this.payload;
//    }
//
//    @Autowired
//    public Producer(KafkaTemplate<String, User> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public User send(User payload) {
//        log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        log.info("User Sent from User Authentication : ");
//        log.info(""+payload);
//        kafkaTemplate.send("users", payload);
//        this.payload = payload;
//        return payload;
//    }
//}
