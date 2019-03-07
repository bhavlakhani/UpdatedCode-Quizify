package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.recommendationservice.domain.Game;
import com.stackroute.quizify.recommendationservice.domain.GameTypeOfGenre;

import java.util.List;

public interface GameTypeOfGenreService {
    List<GameTypeOfGenre> getAllRelationships();

    GameTypeOfGenre createRelationship(Game game);
}
