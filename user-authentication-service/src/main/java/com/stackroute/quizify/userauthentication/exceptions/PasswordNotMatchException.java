package com.stackroute.quizify.userauthentication.exceptions;

public class PasswordNotMatchException extends Exception {

    String message;

    public PasswordNotMatchException(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
