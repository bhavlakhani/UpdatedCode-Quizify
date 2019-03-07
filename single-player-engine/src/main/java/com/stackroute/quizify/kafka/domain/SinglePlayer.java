package com.stackroute.quizify.kafka.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class SinglePlayer {

    private long playerId;
    private Game game;
    private int gameScore;
    private int playerScore;
}
