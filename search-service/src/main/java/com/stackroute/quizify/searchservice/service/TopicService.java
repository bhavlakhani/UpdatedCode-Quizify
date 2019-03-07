package com.stackroute.quizify.searchservice.service;

import com.stackroute.quizify.searchservice.domain.Game;
import com.stackroute.quizify.searchservice.domain.Topics;
import com.stackroute.quizify.searchservice.exception.NoGameFoundException;
import com.stackroute.quizify.searchservice.exception.TopicDoesNotExistsException;
import com.stackroute.quizify.searchservice.exception.TopicAlreadyExistsException;

import java.util.List;

/*
 * This "TopicService" Interface is used to declare all the necessary services/methods
 * which are must be implemented by the Implementing Class (TopicServiceImpl).
 */

public interface TopicService {
    Topics saveTopic(Topics topics) throws TopicAlreadyExistsException;
//    List<Topic> getAllTopicByName(String topicName) throws TopicDoesNotExistsException;
    List<Topics> getAllTopicByStartsWith(String topicName) throws TopicDoesNotExistsException;

    Game deleteGameById(String name, long gameId) throws TopicDoesNotExistsException, NoGameFoundException;
}
