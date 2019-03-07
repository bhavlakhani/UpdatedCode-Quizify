package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.recommendationservice.domain.Played;
import com.stackroute.quizify.recommendationservice.domain.SinglePlayer;

import java.util.List;


public interface PlayedRelationshipService {

    List<Played> getAllRelationships();

    Played createRelationship(SinglePlayer singlePlayer);

}
