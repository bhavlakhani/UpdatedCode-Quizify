package com.stackroute.quizify.dto.model;

import lombok.Data;

@Data
public class SinglePlayerDTO {
    private GameDTO game;
    private UserDTO user;
}
