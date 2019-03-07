package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.recommendationservice.domain.LikesTopic;
import com.stackroute.quizify.recommendationservice.domain.User;

import java.util.List;

public interface LikesTopicService {

    List<LikesTopic> getAllRelationships();

    List<LikesTopic> createRelationship(User user);

}
