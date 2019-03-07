package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.Game;
import com.stackroute.quizify.recommendationservice.domain.GameIsATopic;
import com.stackroute.quizify.recommendationservice.service.GameIsATopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j/gameisatopic")
public class GameIsATopicController {

    GameIsATopicService gameIsATopicService;

    @Autowired
    public GameIsATopicController(GameIsATopicService gameIsATopicService) {
        this.gameIsATopicService = gameIsATopicService;
    }

    @GetMapping("/")
    public List<GameIsATopic> getAll(){
        return gameIsATopicService.getAllRelationships();
    }

    @PostMapping("/")
    public GameIsATopic create(@RequestBody Game game){
        return gameIsATopicService.createRelationship(game);
    }
}
