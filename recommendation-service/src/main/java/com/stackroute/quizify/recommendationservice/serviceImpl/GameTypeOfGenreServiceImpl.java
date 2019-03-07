package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.recommendationservice.domain.Game;
import com.stackroute.quizify.recommendationservice.domain.GameTypeOfGenre;
import com.stackroute.quizify.recommendationservice.domain.Genre;
import com.stackroute.quizify.recommendationservice.repository.GameTypeOfGenreRepository;
import com.stackroute.quizify.recommendationservice.service.GameTypeOfGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameTypeOfGenreServiceImpl implements GameTypeOfGenreService {

    private GameTypeOfGenreRepository gameTypeOfGenreRepository;

    @Autowired
    public GameTypeOfGenreServiceImpl(GameTypeOfGenreRepository gameTypeOfGenreRepository) {
        this.gameTypeOfGenreRepository = gameTypeOfGenreRepository;
    }

    @Override
    public List<GameTypeOfGenre> getAllRelationships() {
        return gameTypeOfGenreRepository.getAllRelationships();
    }

    @Override
    public GameTypeOfGenre createRelationship(Game game) {
        long gameId=game.getId();
        Genre genre=game.getGenre();
        long genreId=genre.getId();
        System.out.println("======================================================  gameid: "+gameId+"  genreId: "+genreId+"======================================================");
        return gameTypeOfGenreRepository.createRelationship(gameId,genreId);
    }
}
