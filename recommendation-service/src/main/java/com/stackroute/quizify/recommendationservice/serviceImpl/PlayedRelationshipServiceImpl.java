package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.recommendationservice.domain.Played;
import com.stackroute.quizify.recommendationservice.domain.SinglePlayer;
import com.stackroute.quizify.recommendationservice.repository.PlayedRelationshipRepository;
import com.stackroute.quizify.recommendationservice.service.PlayedRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayedRelationshipServiceImpl implements PlayedRelationshipService {

    PlayedRelationshipRepository playedRelationshipRepository;


    @Autowired
    public PlayedRelationshipServiceImpl(PlayedRelationshipRepository playedRelationshipRepository) {
        this.playedRelationshipRepository = playedRelationshipRepository;
    }

    @Override
    public List<Played> getAllRelationships() {
        return playedRelationshipRepository.getAllRelationships();
    }

    @Override
    public Played createRelationship(SinglePlayer singlePlayer) {
        long userId= singlePlayer.getUserId();
        System.out.println(" user ------------------------- /n " + userId);
        long gameId= singlePlayer.getGameId();
        System.out.println("game-------------------------------/n"+gameId);
        return playedRelationshipRepository.createRelationship(userId,gameId);
    }

}
