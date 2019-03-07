package com.stackroute.quizify.searchservice.exception;

public class NoGameFoundException extends Exception {
    private String message;

    public NoGameFoundException() {
        super();
    }

    public NoGameFoundException(String message) {
        super(message);
        this.message = message;
    }
}