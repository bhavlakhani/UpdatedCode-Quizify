package com.stackroute.quizify.userauthentication.jwt;

import com.stackroute.quizify.userauthentication.domain.User;

import java.util.Map;
@FunctionalInterface
public interface SecurityTokenGenrator
{
    Map<String, String> generateToken(User user);
}
