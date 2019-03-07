package com.stackroute.quizify.searchservice.service;

import com.stackroute.quizify.searchservice.domain.Game;
import com.stackroute.quizify.searchservice.exception.GenreDoesNotExistsException;
import com.stackroute.quizify.searchservice.exception.NoGameFoundException;
import com.stackroute.quizify.searchservice.exception.TopicDoesNotExistsException;

import java.util.List;

public interface UniversalService {
    List<Game> searchGame(String searchKey) throws NoGameFoundException, GenreDoesNotExistsException, TopicDoesNotExistsException;

    Game deleteGame(String topicName, String genreName, long gameId) throws NoGameFoundException, TopicDoesNotExistsException, GenreDoesNotExistsException;
}
