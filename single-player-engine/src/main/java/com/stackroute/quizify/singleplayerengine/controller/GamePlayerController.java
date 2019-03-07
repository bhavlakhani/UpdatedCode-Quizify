package com.stackroute.quizify.singleplayerengine.controller;



import com.stackroute.quizify.kafka.domain.Game;

import com.stackroute.quizify.kafka.domain.SinglePlayer;

import com.stackroute.quizify.singleplayerengine.service.PlayerService;

import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;



@CrossOrigin

@RestController

@RequestMapping("/api/v1")

@Api(description="Single Player Service")

@Slf4j

public class GamePlayerController {



    private PlayerService playerService;

    private ResponseEntity<?> responseEntity;



    RestTemplate restTemplate=new RestTemplate();

	SinglePlayer singlePlayer;



    @Autowired

    public GamePlayerController(PlayerService playerService)

    {

	        singlePlayer = new SinglePlayer();

        this.playerService = playerService;

    }



    @ApiOperation(value = "Get User Game")

    @GetMapping(value = "/game/{id}")

    public ResponseEntity<?> getGame( @PathVariable long id)

    {
        String url = "http://13.232.243.68:8102/api/v1/game/game/" +id;

            Game game = restTemplate.getForObject(url, Game.class);



            singlePlayer.setGame(game);



            return new ResponseEntity<SinglePlayer>(singlePlayer,HttpStatus.OK);

    }



   @ApiOperation(value = "get user data")

   @GetMapping(value="/user/{playerId}")

   public ResponseEntity<?> getUser( @PathVariable long playerId)

   {

       singlePlayer.setPlayerId(playerId);

       return new ResponseEntity<SinglePlayer>(singlePlayer,HttpStatus.OK);

   }



    @ApiOperation(value = "Get User Game")

    @GetMapping(value = "/user/{playerId}/game/{id}")

    public ResponseEntity<?> getGame(@PathVariable long playerId , @PathVariable long id)

    {

        String url = "http://localhost:8102/api/v1/game/game/" +id;

            Game game = restTemplate.getForObject(url, Game.class);



            singlePlayer.setGame(game);



		singlePlayer.setPlayerId(playerId);



            return new ResponseEntity<SinglePlayer>(singlePlayer,HttpStatus.OK);

    }

}
