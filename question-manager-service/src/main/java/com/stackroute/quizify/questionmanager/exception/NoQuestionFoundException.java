package com.stackroute.quizify.questionmanager.exception;
/*
*
* This "NoQuestionFoundException" is a custom class for an exception which will indicate that
* "No Question Found for a given Category and a given Topic"
*
*/
public class NoQuestionFoundException extends Exception {
    private String message;

    public NoQuestionFoundException(String message) {
        super(message);
        this.message = message;
    }
}
