package com.stackroute.quizify.searchservice.controller;

import com.stackroute.quizify.searchservice.domain.Topics;
import com.stackroute.quizify.searchservice.exception.TopicDoesNotExistsException;
import com.stackroute.quizify.searchservice.service.TopicService;
import com.stackroute.quizify.searchservice.exception.TopicAlreadyExistsException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@Api(description="Search by Topic")
public class TopicController {
    private TopicService topicService;
    private ResponseEntity<?> responseEntity;

    @Autowired
    public TopicController(TopicService topicService){
        this.topicService = topicService;
    }

//    @ApiOperation(value = "Search Topic By Name")
//    @GetMapping("/search/{topicName}")
//    public ResponseEntity<?> searchTopicByName(@PathVariable String topicName){
//        try {
//            return new ResponseEntity<List<Topic>>(topicService.getAllTopicByName(topicName), HttpStatus.OK);
//        }
//        catch (TopicDoesNotExistsException e)
//        {
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }

    @ApiOperation(value = "Save Genre")
    @PostMapping("/search-topic")
    public ResponseEntity<?> saveTopic(@RequestBody Topics topics){
        try
        {
            return new ResponseEntity<Topics>(topicService.saveTopic(topics), HttpStatus.OK);
        }
        catch (TopicAlreadyExistsException e)
        {
            return new ResponseEntity<String >(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @ApiOperation(value = "Search Topic By Starts With")
    @GetMapping("/search-topic/{topicName}")
    public ResponseEntity<?>searchTopicByStartsWith(@PathVariable String topicName){
        try {
            return new ResponseEntity<List<Topics>>(topicService.getAllTopicByStartsWith(topicName), HttpStatus.OK);
        }
        catch (TopicDoesNotExistsException e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
