package com.stackroute.quizify.userregistrationservice.service;

import com.stackroute.quizify.dto.mapper.UserMapper;
import com.stackroute.quizify.dto.model.UserDTO;
import com.stackroute.quizify.kafka.Producer;
import com.stackroute.quizify.userregistrationservice.domain.User;
import com.stackroute.quizify.userregistrationservice.exceptions.UserAlreadyExistException;
import com.stackroute.quizify.userregistrationservice.exceptions.UserNotFoundException;
import com.stackroute.quizify.userregistrationservice.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private Producer producer;
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Producer producer, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.producer = producer;
        this.userMapper = userMapper;
    }

    @Override
    public User saveUser(UserDTO userDTO) throws UserAlreadyExistException {
        if (userRepository.existsById(userDTO.getId())) {
            throw new UserAlreadyExistException("user already exists");
        }
        else
        {
            producer.send(userDTO);
            if(this.userRepository.findTopByOrderByIdDesc().isEmpty())
                userDTO.setId(1);
            else
                userDTO.setId(this.userRepository.findTopByOrderByIdDesc().get().getId()+1);
            return this.userRepository.save(this.userMapper.userDTOToUser(userDTO));
        }
    }

    @Override
    public User getUser(long id) throws UserNotFoundException {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User updateUser(UserDTO userDTO) throws UserNotFoundException {
        if (userRepository.existsById(userDTO.getId())) {
            this.userRepository.save(this.userMapper.userDTOToUser(userDTO));
            producer.send(userDTO);
            return this.userMapper.userDTOToUser(userDTO);
        }
        else
            throw new UserNotFoundException("user not found");
    }


    @Override
    public User deleteUser(long id) throws UserNotFoundException {

        if(this.userRepository.existsById(id)) {
            User user = this.userRepository.findById(id).get();
            this.userRepository.delete(user);
            return user;
        }
        else
            throw new UserNotFoundException("user not found");

    }
}