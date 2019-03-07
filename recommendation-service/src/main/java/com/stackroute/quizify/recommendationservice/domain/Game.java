package com.stackroute.quizify.recommendationservice.domain;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import java.util.List;

@NodeEntity
@Data
public class Game {
    @Id //@GeneratedValue
    private long id;
    @Property
    private String name;
//    @Property
    private Category category;
//    @Property
    private Topic topic;
//    @Property
    private Genre genre;
//    @Property
    private Tag tag;
    private String level;
    private String imageUrl;
    private int numOfQuestion;
    private int timeDuration;
    private int liked;
    @Property
    private int playCount;
    private List<String> rules;
}
