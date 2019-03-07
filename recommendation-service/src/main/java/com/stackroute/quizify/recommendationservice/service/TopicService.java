package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.recommendationservice.domain.Topic;

import java.util.List;


public interface TopicService {

    public List<Topic> getAll();

    public List<Topic> getTopicsByCategory(long categoryId);
}
