package com.stackroute.quizify.recommendationservice.domain;


import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import java.util.List;


@NodeEntity
@Data
public class User {
    @Id @GeneratedValue
    private long id;
    @Property
    private String name;
    private List<Topic> topics;
    private List<Genre> genres;
    @Property
    private String gender;
}


//    CREATE (Peter:User{userName: 'Peter N', gender: 'male'}) CREATE (Sam:User {userName: 'Sam Sheldon', gender: 'male'}) CREATE (Ryan:User {userName: 'Ryan A', gender: 'male'})

