package com.stackroute.quizify.userauthentication.exceptions;

public class UserAlreadyExists extends Exception {

    String message;

    public UserAlreadyExists(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}