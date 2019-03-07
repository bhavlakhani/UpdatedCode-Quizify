package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.recommendationservice.domain.Game;
import com.stackroute.quizify.recommendationservice.domain.GameIsATopic;
import com.stackroute.quizify.recommendationservice.domain.Topic;
import com.stackroute.quizify.recommendationservice.repository.GameIsATopicRepository;
import com.stackroute.quizify.recommendationservice.service.GameIsATopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameIsATopicServiceImpl implements GameIsATopicService {

    private GameIsATopicRepository gameIsATopicRepository;

    @Autowired
    public GameIsATopicServiceImpl(GameIsATopicRepository gameIsATopicRepository) {
        this.gameIsATopicRepository = gameIsATopicRepository;
    }

    @Override
    public List<GameIsATopic> getAllRelationships() {
        return gameIsATopicRepository.getAllRelationships();
    }

    @Override
    public GameIsATopic createRelationship(Game game) {
        long gameId=game.getId();
        Topic topic=game.getTopic();
        long topicId=topic.getId();
        System.out.println("======================================================  gameid: "+gameId+"  topicId: "+topicId+"======================================================");
        return gameIsATopicRepository.createRelationship(gameId,topicId);
    }
}
