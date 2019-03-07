package com.stackroute.quizify.gamemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Specified Game Not Found on server")
public class GameNotFoundException extends Exception{
    private String message;
        public GameNotFoundException(String message) {
            super(message);
            this.message=message;
        }
}
