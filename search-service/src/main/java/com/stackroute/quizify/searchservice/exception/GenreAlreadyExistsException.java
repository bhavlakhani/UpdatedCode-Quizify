package com.stackroute.quizify.searchservice.exception;

public class GenreAlreadyExistsException extends Exception {
    private String message;

    public GenreAlreadyExistsException(){
        super();
    }

    public GenreAlreadyExistsException(String message){
        super(message);
        this.message=message;
    }
}
