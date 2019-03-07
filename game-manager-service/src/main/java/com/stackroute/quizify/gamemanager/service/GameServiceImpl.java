package com.stackroute.quizify.gamemanager.service;

import com.stackroute.quizify.dto.model.GameDTO;
import com.stackroute.quizify.gamemanager.exception.GameAlreadyExistsException;
import com.stackroute.quizify.gamemanager.exception.GameNotFoundException;
import com.stackroute.quizify.gamemanager.exception.NoGameFoundException;
import com.stackroute.quizify.gamemanager.domain.Game;
import com.stackroute.quizify.kafka.Producer;
import com.stackroute.quizify.gamemanager.repository.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GameServiceImpl implements GameService {

    private static Logger log = LoggerFactory.getLogger(GameServiceImpl.class);

    private GameRepository gameRepository;
    private Producer producer;


    @Autowired
    public GameServiceImpl(GameRepository gameRepository, Producer producer){

        this.gameRepository=gameRepository;
        this.producer = producer;
     }

     @Override
     public GameDTO saveGame(Game game) throws GameAlreadyExistsException {
         if(this.gameRepository.existsById(game.getId()))
             throw new GameAlreadyExistsException("Game already exists");
         else {
             if(this.gameRepository.findTopByOrderByIdDesc().isEmpty())
                 game.setId(1);
             else
                 game.setId(this.gameRepository.findTopByOrderByIdDesc().get().getId()+1);
             return producer.send(this.gameRepository.save(game));
         }


     }

    @Override
    public Game deleteGame(long gameId) throws GameNotFoundException {
        if(this.gameRepository.existsById(gameId)) {
            Game game = this.gameRepository.findById(gameId).get();
            this.gameRepository.delete(game);
            return game;
        }
        else
            throw  new GameNotFoundException("Game Not exist");
    }

    @Override
    public GameDTO updateGame(Game updatedGame) throws GameNotFoundException {

    if(this.gameRepository.existsById(updatedGame.getId()))
        return producer.send(this.gameRepository.save(updatedGame));
    else
        throw new GameNotFoundException("Game not found");

    }

    @Override
    public Game findGameById(long id) throws GameNotFoundException {
        if (this.gameRepository.existsById(id))
            return this.gameRepository.findById(id).get();
        else
            throw new GameNotFoundException("Game Not Found!");
    }

    @Override
    public List<Game> getAllGames() throws NoGameFoundException {
        List<Game> games = this.gameRepository.findAll();
        if (games.isEmpty())
            throw new NoGameFoundException("No Game Found!");
        else
            return games;
    }

    @Override
    public List<Game> getAllGamesByTopic(String topicName) throws NoGameFoundException {
        List<Game> games = this.gameRepository.findGamesByTopic(topicName);
        if (games.isEmpty())
            throw new NoGameFoundException("No Game Found!");
        else
            return games;
    }

    @Override
    public List<Game> getAllGamesByGenre(String genreName) throws NoGameFoundException {
        List<Game> games = this.gameRepository.findGamesByGenre(genreName);
        if (games.isEmpty())
            throw new NoGameFoundException("No Game Found!");
        else
            return games;
    }

    @Override
    public List<Game> getAllGamesByTag(String tagName) throws NoGameFoundException {
        List<Game> games = this.gameRepository.findGamesByTag(tagName);
        if (games.isEmpty())
            throw new NoGameFoundException("No Game Found!");
        else
            return games;
    }
}
