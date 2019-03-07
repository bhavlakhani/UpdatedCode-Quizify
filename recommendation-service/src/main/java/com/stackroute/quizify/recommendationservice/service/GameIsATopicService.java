package com.stackroute.quizify.recommendationservice.service;


import com.stackroute.quizify.recommendationservice.domain.Game;
import com.stackroute.quizify.recommendationservice.domain.GameIsATopic;

import java.util.List;

public interface GameIsATopicService {
    List<GameIsATopic> getAllRelationships();

    GameIsATopic createRelationship(Game game);
}
