package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.LikesGenre;
import com.stackroute.quizify.recommendationservice.domain.User;
import com.stackroute.quizify.recommendationservice.service.LikesGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j/likesgenre")
public class LikesGenreController {
    private LikesGenreService likesGenreService;

    @Autowired
    public LikesGenreController(LikesGenreService likesGenreService) {
        this.likesGenreService = likesGenreService;
    }

    @GetMapping("/")
    public List<LikesGenre> getAll(){
        return likesGenreService.getAllRelationships();
    }


    @PostMapping("/")
    public String create(@RequestBody User user){
        return likesGenreService.createRelationship(user);
    }

}
