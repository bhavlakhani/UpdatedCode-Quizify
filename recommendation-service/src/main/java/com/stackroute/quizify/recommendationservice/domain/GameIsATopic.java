package com.stackroute.quizify.recommendationservice.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

@Data
@RelationshipEntity(type = "game_is_a")
public class GameIsATopic {
    @Id
    @GeneratedValue
    private long id;

    @StartNode
    private Game game;
    @EndNode
    private Topic topic;
}
