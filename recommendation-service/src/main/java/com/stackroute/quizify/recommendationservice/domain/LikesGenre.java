package com.stackroute.quizify.recommendationservice.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

@Data
@RelationshipEntity(type = "LikesGenre")
public class LikesGenre {
    @Id
    @GeneratedValue
    private long id;

    @StartNode
    private User user;
    @EndNode
    private Genre genre;
}
