package com.stackroute.quizify.recommendationservice.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

@Data
@RelationshipEntity(type = "LikesTopic")
public class LikesTopic {
    @Id
    @GeneratedValue
    private long id;

    @StartNode
    private User user;
    @EndNode
    private Topic topic;
}
