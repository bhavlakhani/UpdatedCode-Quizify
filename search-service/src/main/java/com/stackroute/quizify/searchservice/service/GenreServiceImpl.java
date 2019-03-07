package com.stackroute.quizify.searchservice.service;


import com.stackroute.quizify.searchservice.domain.Game;
import com.stackroute.quizify.searchservice.exception.GenreAlreadyExistsException;
import com.stackroute.quizify.searchservice.domain.Genres;
import com.stackroute.quizify.searchservice.exception.GenreDoesNotExistsException;
import com.stackroute.quizify.searchservice.exception.NoGameFoundException;
import com.stackroute.quizify.searchservice.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * This "GenreServiceImpl" Class implements all the methods declared by "GenreService" Interface.
 *
 * Spring @Service annotation is used with classes that provide business functionalities/logics.
 */


@Service
public class GenreServiceImpl implements GenreService{
    GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

//    @Override
//    public List<Genre> getAllGenreByName(String genreName) throws GenreDoesNotExistsException {
//        List<Genre> allGenres = genreRepository.searchByGenreName(genreName);
//        if(allGenres==null)
//            throw new GenreDoesNotExistsException("No Game found");
//        else
//            return allGenres;
//    }

    @Override
    public Genres saveGenre(Genres genres) throws GenreAlreadyExistsException {
        if (this.genreRepository.existsById(genres.getId()))
            throw new GenreAlreadyExistsException("Genre Already Exists!");
        else
        {
            if(this.genreRepository.findTopByOrderByIdDesc().isEmpty())
                genres.setId(1);
            else
                genres.setId(this.genreRepository.findTopByOrderByIdDesc().get().getId()+1);
            return genreRepository.save(genres);
        }
    }

    @Override
    public List<Genres> getAllGenreByStartsWith(String genreName) throws GenreDoesNotExistsException {
        List<Genres> genres = genreRepository.searchByGenreAlphabet(genreName);
        if(genres==null)
            throw new GenreDoesNotExistsException("No Game Found");
        else
            return genres;
    }

    @Override
    public Game deleteGameById(String genreName, long gameId) throws GenreDoesNotExistsException, NoGameFoundException {
        if (this.genreRepository.existsByName(genreName))
        {
            Genres genres = this.genreRepository.findByName(genreName);
            List<Game> games = genres.getGames();
            if (games.isEmpty())
                throw new NoGameFoundException("No Game Found!");
            for (Game game: games)
            {
                if (game.getId() == gameId)
                {
                    Game deletedGame = game;
                    games.remove(deletedGame);
                    genres.setGames(games);
                    this.genreRepository.save(genres);
                    return deletedGame;
                }
            }
            throw new NoGameFoundException("Game Not Found!");

        }
        else
            throw new GenreDoesNotExistsException("Genre Doesn't Exist!");
    }

}
