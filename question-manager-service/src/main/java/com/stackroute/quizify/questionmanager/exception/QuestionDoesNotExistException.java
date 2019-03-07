package com.stackroute.quizify.questionmanager.exception;
/*
 *
 * This "QuestionDoesNotExistException" is a custom class for an exception which will indicate that
 * "Question Does Not Exist according to question ID"
 *
 */
public class QuestionDoesNotExistException extends Exception {
    private String message;

    public QuestionDoesNotExistException(String message) {
        super(message);
        this.message = message;
    }
}
