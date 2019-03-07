package com.stackroute.quizify.recommendationservice.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

@Data
@RelationshipEntity(type = "game_type_of")
public class GameTypeOfGenre {
    @Id
    @GeneratedValue
    private long id;

    @StartNode
    private Game game;
    @EndNode
    private Genre genre;
}
