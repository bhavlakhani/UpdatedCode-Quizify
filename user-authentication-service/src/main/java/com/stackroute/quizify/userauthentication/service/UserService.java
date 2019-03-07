package com.stackroute.quizify.userauthentication.service;

import com.stackroute.quizify.userauthentication.domain.User;
import com.stackroute.quizify.userauthentication.exceptions.UserAlreadyExists;

import java.util.List;

public interface UserService
{
    public User saveUser(User user) throws UserAlreadyExists; //users ADDED

    public List<User> getAllUsers();  ///RETRIEVE users

    public User findByUserIdAndPassword(String username,String password);
}
