package com.stackroute.quizify.userauthentication.service;

import com.stackroute.quizify.userauthentication.domain.User;
import com.stackroute.quizify.userauthentication.exceptions.UserAlreadyExists;
import com.stackroute.quizify.userauthentication.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository repo) {
        this.userRepo = repo;
    }


    @Override
    public User findByUserIdAndPassword(String username, String password) {
        return userRepo.findByNameAndPassword(username, password);
    }


    @Override
    public User saveUser(User user) throws UserAlreadyExists {
        if(userRepo.existsByName(user.getName())){
            throw new UserAlreadyExists("User Name already exists!!");
        }
        User userSaved = userRepo.save(user);
        return userSaved;

    }


    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }



}
