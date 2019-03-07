package com.stackroute.quizify.recommendationservice.controller;

import com.stackroute.quizify.recommendationservice.domain.User;
import com.stackroute.quizify.recommendationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/neo4j/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/id")
    public User getOne(@RequestParam("userId") long userId){
        return userService.getone(userId);
    }

    @PostMapping("/")
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @DeleteMapping("/")
    public User delete(@RequestParam("userId") long userId){
        System.out.println(userId);
        return userService.delete(userId);
    }

    @PutMapping("/")
    public User update(@RequestBody User user)
    {
        return userService.update(user);
    }

}
