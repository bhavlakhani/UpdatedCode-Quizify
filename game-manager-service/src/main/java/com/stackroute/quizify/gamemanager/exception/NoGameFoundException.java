package com.stackroute.quizify.gamemanager.exception;
/*
*
* This "NoGameFoundException" is a custom class for an exception which will indicate that
* "No Game Found for a given Category and a given Topic"
*
*/
public class NoGameFoundException extends Exception {
    private String message;

    public NoGameFoundException(String message) {
        super(message);
        this.message = message;
    }
}
