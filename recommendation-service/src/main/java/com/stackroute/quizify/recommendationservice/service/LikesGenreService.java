package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.recommendationservice.domain.LikesGenre;
import com.stackroute.quizify.recommendationservice.domain.User;

import java.util.List;

public interface LikesGenreService {

    List<LikesGenre> getAllRelationships();

    String createRelationship(User user);
}
