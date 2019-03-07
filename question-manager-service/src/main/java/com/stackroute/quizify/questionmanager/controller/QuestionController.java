package com.stackroute.quizify.questionmanager.controller;

import com.stackroute.quizify.dto.model.QuestionDTO;
import com.stackroute.quizify.questionmanager.exception.EnoughQuestionsNotFound;
import com.stackroute.quizify.questionmanager.exception.NoQuestionFoundException;
import com.stackroute.quizify.questionmanager.exception.QuestionAlreadyExistsException;
import com.stackroute.quizify.questionmanager.exception.QuestionDoesNotExistException;
import com.stackroute.quizify.questionmanager.service.QuestionService;
import com.stackroute.quizify.questionmanager.domain.Question;
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
@Api(description="Question Manager Service")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @ApiOperation(value = "Add Question")
    @PostMapping("/questions/question")
    public ResponseEntity<?> saveQuestion(@RequestBody Question question) {
        try {
            return new ResponseEntity<QuestionDTO>(this.questionService.addNewQuestion(question), HttpStatus.OK);
        } catch (QuestionAlreadyExistsException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @ApiOperation(value = "Update Question")
    @PutMapping("/questions/question")
    public ResponseEntity<?> updateQuestion(@RequestBody Question question) {
        try {
            return new ResponseEntity<Question>(this.questionService.updateQuestion(question), HttpStatus.OK);
        } catch (QuestionDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Remove Question")
    @DeleteMapping("/questions/question/{id}")
    public ResponseEntity<?> removeQuestion(@RequestBody long id) {
        try {
            return new ResponseEntity<Question>(this.questionService.removeQuestion(id), HttpStatus.OK);
        } catch (QuestionDoesNotExistException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Get Questions By Tag By Level")
    @GetMapping("/questions/tag/{tagName}/{level}/{numberOfQuestions}")
    public ResponseEntity<?> getQuestionsByTagByLevel(@PathVariable String tagName, @PathVariable String level, @PathVariable int numberOfQuestions) {
        try {
            return new ResponseEntity<List<Question>>(this.questionService.getQuestionsByTagByLevel(tagName, level, numberOfQuestions), HttpStatus.OK);
        } catch (NoQuestionFoundException | EnoughQuestionsNotFound e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @ApiOperation(value = "Get Questions By Tag")
    @GetMapping("/questions/tag/{tagName}/{numberOfQuestions}")
    public ResponseEntity<?> getQuestionsByTag(@PathVariable String tagName, @PathVariable int numberOfQuestions) {
        try {
            return new ResponseEntity<List<Question>>(this.questionService.getQuestionsByTag(tagName, numberOfQuestions), HttpStatus.OK);
        } catch (NoQuestionFoundException | EnoughQuestionsNotFound e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Get All Questions By Tag")
    @GetMapping("/questions/tag/{tagName}")
    public ResponseEntity<?> getAllQuestionsByTag(@PathVariable String tagName) {
        try {
            return new ResponseEntity<List<Question>>(this.questionService.getAllQuestionsByTag(tagName), HttpStatus.OK);
        } catch (NoQuestionFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Get Questions By Topic By Level")
    @GetMapping("/questions/topic/{topicName}/{level}/{numberOfQuestions}")
    public ResponseEntity<?> getQuestionsByTopicByLevel(@PathVariable String topicName, @PathVariable String level, @PathVariable int numberOfQuestions) {
        try {
            return new ResponseEntity<List<Question>>(this.questionService.getQuestionsByTopicByLevel(topicName, level, numberOfQuestions), HttpStatus.OK);
        } catch (NoQuestionFoundException | EnoughQuestionsNotFound e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @ApiOperation(value = "Get Questions By Topic")
    @GetMapping("/questions/topic/{topicName}/{numberOfQuestions}")
    public ResponseEntity<?> getQuestionsByTopic(@PathVariable String topicName, @PathVariable int numberOfQuestions) {
        try {
            return new ResponseEntity<List<Question>>(this.questionService.getQuestionsByTopic(topicName, numberOfQuestions), HttpStatus.OK);
        } catch (NoQuestionFoundException | EnoughQuestionsNotFound e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Get All Questions By Topic")
    @GetMapping("/questions/topic/{topicName}")
    public ResponseEntity<?> getAllQuestionsByTopic(@PathVariable String topicName) {
        try {
            return new ResponseEntity<List<Question>>(this.questionService.getAllQuestionsByTopic(topicName), HttpStatus.OK);
        } catch (NoQuestionFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @ApiOperation(value = "Get Questions By Genre By Level")
    @GetMapping("/questions/genre/{genreName}/{level}/{numberOfQuestions}")
    public ResponseEntity<?> getQuestionsByGenreByLevel(@PathVariable String genreName, @PathVariable String level, @PathVariable int numberOfQuestions) {
        try {
            return new ResponseEntity<List<Question>>(this.questionService.getQuestionsByGenreByLevel(genreName, level, numberOfQuestions), HttpStatus.OK);
        } catch (NoQuestionFoundException | EnoughQuestionsNotFound e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @ApiOperation(value = "Get Questions By Genre")
    @GetMapping("/questions/genre/{genreName}/{numberOfQuestions}")
    public ResponseEntity<?> getQuestionsByGenre(@PathVariable String genreName, @PathVariable int numberOfQuestions) {
        try {
            return new ResponseEntity<List<Question>>(this.questionService.getQuestionsByGenre(genreName, numberOfQuestions), HttpStatus.OK);
        } catch (NoQuestionFoundException | EnoughQuestionsNotFound e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Get All Questions By Genre")
    @GetMapping("/questions/genre/{genreName}")
    public ResponseEntity<?> getAllQuestionsByGenre(@PathVariable String genreName) {
        try {
            return new ResponseEntity<List<Question>>(this.questionService.getAllQuestionsByGenre(genreName), HttpStatus.OK);
        } catch (NoQuestionFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @ApiOperation(value = "Get Questions By Topic By Genre By Level")
    @GetMapping("/questions/topic/genre/{topicName}/{genreName}/{level}/{numberOfQuestions}")
    public ResponseEntity<?> getQuestionsByTopicByGenreByLevel(@PathVariable String topicName, @PathVariable String genreName, @PathVariable String level, @PathVariable int numberOfQuestions) {
        try {
            return new ResponseEntity<List<Question>>(this.questionService.getQuestionsByTopicByGenreByLevel(topicName, genreName, level, numberOfQuestions), HttpStatus.OK);
        } catch (NoQuestionFoundException | EnoughQuestionsNotFound e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }



}