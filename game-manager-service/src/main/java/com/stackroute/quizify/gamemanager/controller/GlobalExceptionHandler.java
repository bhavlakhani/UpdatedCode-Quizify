package com.stackroute.quizify.gamemanager.controller;

import com.stackroute.quizify.gamemanager.exception.GameAlreadyExistsException;
import com.stackroute.quizify.gamemanager.exception.GameNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Game Already Exists")
    @ExceptionHandler(GameAlreadyExistsException.class)
    public void handleEventAlreadyExists(GameAlreadyExistsException e) {
        log.error("Game alredy Exists");
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Game Not Found")
    @ExceptionHandler(GameNotFoundException.class)
    public void handleEventNotFound() {
        log.error("Game Not Found");
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Something went wrong ")
    public void handleException(Exception e) {
        log.error("Try!!! After sometime");
    }

}

