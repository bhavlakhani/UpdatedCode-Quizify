package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.Topic;
import com.stackroute.quizify.recommendationservice.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j/topic")
public class TopicController {

    private TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/")
    public List<Topic> getAll(){
        return topicService.getAll();
    }

    @GetMapping("/{categoryId}")
    public List<Topic> getTopicsByCategory(@PathVariable("categoryId") long categoryId){
        return topicService.getTopicsByCategory(categoryId);
    }
}


