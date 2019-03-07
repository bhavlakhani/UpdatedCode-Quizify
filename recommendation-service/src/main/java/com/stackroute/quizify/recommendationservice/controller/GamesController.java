package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.Game;
import com.stackroute.quizify.recommendationservice.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j/game")
public class GamesController {

    private GamesService gamessService;

    @Autowired
    public GamesController(GamesService gamessService) {
        this.gamessService = gamessService;
    }

    @GetMapping("/")
    public List<Game> getAll(){
        return gamessService.getAll();
    }

    @GetMapping("/mostplayed")
    public List<Game> getMostPlayed(){
        return gamessService.getMostPlayed();
    }

    @GetMapping("/id")
    public Game getOne(@RequestParam("GamesId") long GamesId){
        return gamessService.getone(GamesId);
    }

    @PostMapping("/")
    public Game create(@RequestBody Game Game){
        return gamessService.create(Game);
    }

    @DeleteMapping("/")
    public Game delete(@RequestParam("GamesId") long GamesId){
        System.out.println(GamesId);
        return gamessService.delete(GamesId);
    }

    @PutMapping("/")
    public Game update(@RequestBody Game Game)
    {
        return gamessService.update(Game);
    }

}
