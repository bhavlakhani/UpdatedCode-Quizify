package com.stackroute.quizify.recommendationservice.controller;


import com.stackroute.quizify.recommendationservice.domain.LikesTopic;
import com.stackroute.quizify.recommendationservice.domain.User;
import com.stackroute.quizify.recommendationservice.service.LikesTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j/likestopic")
public class LikesTopicController {

    LikesTopicService likesTopicService;

    @Autowired
    public LikesTopicController(LikesTopicService likesTopicService) {
        this.likesTopicService = likesTopicService;
    }

    @GetMapping("/")
    public List<LikesTopic> getAll(){
        return likesTopicService.getAllRelationships();
    }

    @PostMapping("/")
    public List<LikesTopic> create(@RequestBody User user){
        return likesTopicService.createRelationship(user);
    }
}

