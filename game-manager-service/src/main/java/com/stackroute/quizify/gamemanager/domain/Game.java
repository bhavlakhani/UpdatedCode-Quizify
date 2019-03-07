package com.stackroute.quizify.gamemanager.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;



@Document(collection="game")
@Data
public class Game {
    @Id
    private long id;
    private String name;
    private Category category;
    private Topic topic;
    private Genre genre;
    private Tag tag;
    private String level;
    private String imageUrl;
    private int numOfQuestion;
    private List<Question> questions;
    private int timeDuration;
    private int liked;
    private int playCount;
    private List<String> rules;
}
