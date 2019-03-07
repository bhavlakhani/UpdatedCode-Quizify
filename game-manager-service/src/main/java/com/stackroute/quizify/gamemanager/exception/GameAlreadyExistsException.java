package com.stackroute.quizify.gamemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Game already exists on server")
public class GameAlreadyExistsException extends Exception{

        private String message;
        public GameAlreadyExistsException(String message) {

            super(message);
            this.message=message;
        }
}
