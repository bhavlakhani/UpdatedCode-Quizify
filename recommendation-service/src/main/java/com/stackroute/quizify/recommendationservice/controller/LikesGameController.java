package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.LikesGame;
import com.stackroute.quizify.recommendationservice.service.LikesGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j/likesgame")
public class LikesGameController {

    LikesGameService likesGameService;

    @Autowired
    public LikesGameController(LikesGameService likesGameService) {
        this.likesGameService = likesGameService;
    }

    @GetMapping("/")
    public List<LikesGame> getAll(){
        return likesGameService.getAllRelationships();
    }


    @PostMapping("/")
    public LikesGame create(@RequestParam("userId") long userId, @RequestParam("gameId") long gameId){
        return likesGameService.createRelationship(userId, gameId);
    }

    @DeleteMapping("/")
    public LikesGame delete(@RequestParam("userId") long userId, @RequestParam("gameId") long gameId){
        return likesGameService.deleteRelationship(userId, gameId);
    }

}
