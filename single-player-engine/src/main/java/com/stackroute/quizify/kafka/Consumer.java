//package com.stackroute.quizify.kafka;
//
//import com.stackroute.quizify.kafka.domain.Game;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class Consumer {
//
//    private Game recievedPayload;
//
//    public Game getRecievedPayload()
//    {
//        return this.recievedPayload;
//    }
//
//    @KafkaListener(topics = "game", groupId = "game-consumers", containerFactory = "kafkaListenerContainerFactory")
//    public void receive(@Payload Game payload) {
//        System.out.println("-----------------------------------------------------------------------------------------");
//        System.out.println("Game Received : ");
//        System.out.println(payload);
//
//        this.recievedPayload = payload;
//    }
//
//}
