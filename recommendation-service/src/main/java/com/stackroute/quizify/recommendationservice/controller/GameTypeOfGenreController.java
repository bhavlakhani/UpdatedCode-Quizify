package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.Game;
import com.stackroute.quizify.recommendationservice.domain.GameTypeOfGenre;
import com.stackroute.quizify.recommendationservice.service.GameTypeOfGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j/gametypeofgenre")
public class GameTypeOfGenreController {

        GameTypeOfGenreService gameTypeOfGenreService;

        @Autowired
        public GameTypeOfGenreController(GameTypeOfGenreService gameTypeOfGenreService) {
            this.gameTypeOfGenreService = gameTypeOfGenreService;
        }

        @GetMapping("/")
        public List<GameTypeOfGenre> getAll(){
            return gameTypeOfGenreService.getAllRelationships();
        }

        @PostMapping("/")
        public GameTypeOfGenre create(@RequestBody Game game){
            return gameTypeOfGenreService.createRelationship(game);
        }

}
