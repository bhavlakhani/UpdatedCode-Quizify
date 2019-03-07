package com.stackroute.quizify.questionmanager.exception;
/*
 *
 * This "QuestionAlreadyExistsException" is a custom class for an exception which will indicate that
 * "Question is Already Existing according to question ID"
 *
 */
public class QuestionAlreadyExistsException extends Exception {
    private String message;

    public QuestionAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
