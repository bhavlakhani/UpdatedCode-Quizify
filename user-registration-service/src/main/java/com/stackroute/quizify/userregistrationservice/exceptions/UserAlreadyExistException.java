package com.stackroute.quizify.userregistrationservice.exceptions;

public class UserAlreadyExistException extends Exception {
    private String message;

    public UserAlreadyExistException(String message){
        super(message);
        this.message=message;
    }
    public UserAlreadyExistException(){
        super();
    }

}
