package com.stackroute.quizify.gamemanager.controller;

import com.stackroute.quizify.dto.model.GameDTO;
import com.stackroute.quizify.gamemanager.exception.GameAlreadyExistsException;
import com.stackroute.quizify.gamemanager.exception.GameNotFoundException;
import com.stackroute.quizify.gamemanager.exception.NoGameFoundException;
import com.stackroute.quizify.gamemanager.service.GameService;
import com.stackroute.quizify.gamemanager.domain.Game;
import com.stackroute.quizify.gamemanager.domain.Genre;
import com.stackroute.quizify.gamemanager.domain.Tag;
import com.stackroute.quizify.gamemanager.domain.Topic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
@Api(description = "Game Manager Services")
public class GameController {

    private GameService gameService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GameController(GameService gameService)
    {
        this.gameService=gameService;
    }

    @ApiOperation(value = "Add Games")
    @PostMapping("/game/game")
    public ResponseEntity<?> saveGame(@RequestBody Game game){
        try {
            return new ResponseEntity<GameDTO>(this.gameService.saveGame(game), HttpStatus.OK);
        } catch (GameAlreadyExistsException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @ApiOperation(value = "Delete Game")
    @DeleteMapping("/games/game/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable long id)
    {
        try {
            return new ResponseEntity<Game>(this.gameService.deleteGame(id), HttpStatus.OK);
        } catch (GameNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
    @ApiOperation(value = "Updating Game")
    @PutMapping("/game/game")
    public ResponseEntity<?> updateGame(@RequestBody Game updatedGame){
        try {
            return new ResponseEntity<GameDTO>(this.gameService.updateGame(updatedGame), HttpStatus.OK);
        } catch (GameNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Get Game By Id")
    @GetMapping("/game/{id}")
    public ResponseEntity<?> getAllGames(@PathVariable long id){
        try {
            return new ResponseEntity<Game>(this.gameService.findGameById(id), HttpStatus.OK);
        } catch (GameNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Get All Games")
    @GetMapping("/game")
    public ResponseEntity<?> getAllGames(){
        try {
            return new ResponseEntity<List<Game>>(this.gameService.getAllGames(), HttpStatus.OK);
        } catch (NoGameFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Get All Games by Topic")
    @GetMapping("/game/topic/{topicName}")
    public ResponseEntity<?> getAllGamesByTopic(@PathVariable String topicName){
        try {
            return new ResponseEntity<List<Game>>(this.gameService.getAllGamesByTopic(topicName), HttpStatus.OK);
        } catch (NoGameFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Get All Games by Genre")
    @GetMapping("/game/genre/{genreName}")
    public ResponseEntity<?> getAllGamesByGenre(@PathVariable String genreName){
        try {
            return new ResponseEntity<List<Game>>(this.gameService.getAllGamesByGenre(genreName), HttpStatus.OK);
        } catch (NoGameFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Get All Games by Tag")
    @GetMapping("/game/tag/{tagName}")
    public ResponseEntity<?> getAllGamesByTag(@PathVariable String tagName){
        try {
            return new ResponseEntity<List<Game>>(this.gameService.getAllGamesByTag(tagName), HttpStatus.OK);
        } catch (NoGameFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }




    @ApiOperation(value = "Generate Live Game")
    @GetMapping(value = "/game/game/{id}")
    public ResponseEntity<?> generateLiveGameByTopic(@PathVariable long id){
        try {
            Game liveGame = this.gameService.findGameById(id);
            Topic topic = liveGame.getTopic();
            Genre genre = liveGame.getGenre();
            Tag tag = liveGame.getTag();
            String level = liveGame.getLevel();
            int numberOfQuestions = liveGame.getNumOfQuestion();
            String url = "http://localhost:8092/question-manager-service/api/v1/questions/";

            if (tag !=null)
            {
                url += "tag/"+tag.getName()+"/"+level+"/"+numberOfQuestions;

            }
            else if (genre !=null && topic==null)
            {
                url += "genre/"+genre.getName()+"/"+level+"/"+numberOfQuestions;

            }
            else if (genre==null && topic!=null)
            {
                url += "topic/"+topic.getName()+"/"+level+"/"+numberOfQuestions;
            }
            else if (genre!=null && topic!=null)
            {
                url += "topic/genre/"+topic.getName()+"/"+genre.getName()+"/"+level+"/"+numberOfQuestions;
            }

//            System.out.println(url);

            try
            {
                liveGame.setQuestions(restTemplate.getForObject(url, ArrayList.class));
            }
            catch (HttpClientErrorException e)
            {
                return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
            }


//            restTemplate.exchange(url, HttpMethod.GET,null, ArrayList.class);
            return new ResponseEntity<Game>(liveGame, HttpStatus.OK);

        } catch (GameNotFoundException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
