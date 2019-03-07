package com.stackroute.quizify.questionmanager.exception;

public class EnoughQuestionsNotFound extends Exception {
    private String message;

    public EnoughQuestionsNotFound(String message) {
        super(message);
        this.message = message;
    }
}