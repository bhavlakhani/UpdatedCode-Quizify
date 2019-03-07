package com.stackroute.quizify.userauthentication.exceptions;

public class UserNameOrPasswordEmpty extends Exception {

String message;
    public UserNameOrPasswordEmpty() {
    }

    public UserNameOrPasswordEmpty(String message) {
        this.message=message;
    }
}
