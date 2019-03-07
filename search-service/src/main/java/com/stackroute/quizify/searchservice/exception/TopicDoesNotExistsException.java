package com.stackroute.quizify.searchservice.exception;

public class TopicDoesNotExistsException extends Exception{
    private String message;

    public TopicDoesNotExistsException(){
        super();
    }

    public TopicDoesNotExistsException(String message){
        super(message);
        this.message=message;
    }
}
