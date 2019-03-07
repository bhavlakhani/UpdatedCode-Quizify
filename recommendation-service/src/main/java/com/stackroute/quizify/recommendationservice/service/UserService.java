package com.stackroute.quizify.recommendationservice.service;

import com.stackroute.quizify.recommendationservice.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> getAll();

    public User getone(long userId);

    public User create(User user);

    public User delete(long userId);

    public User update(User user);
}
