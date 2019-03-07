package com.stackroute.quizify.userregistrationservice.service;

import com.stackroute.quizify.dto.model.UserDTO;
import com.stackroute.quizify.userregistrationservice.domain.User;
import com.stackroute.quizify.userregistrationservice.exceptions.UserAlreadyExistException;
import com.stackroute.quizify.userregistrationservice.exceptions.UserNotFoundException;

import java.util.List;

public interface UserService {

     User saveUser(UserDTO userDTO) throws UserAlreadyExistException;
     User getUser(long id) throws UserNotFoundException;
     List<User> getAllUsers()throws UserNotFoundException;
     User updateUser(UserDTO userDTO) throws UserNotFoundException;
     User deleteUser(long id) throws UserNotFoundException;

}
