package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.recommendationservice.domain.LikesGame;

import java.util.List;

public interface LikesGameService {
    List<LikesGame> getAllRelationships();

    LikesGame createRelationship(long userId, long gameId);

    LikesGame deleteRelationship(long userId, long gameId);

}
