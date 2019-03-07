package com.stackroute.quizify.dto.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class QuestionDTO {
    @Id
    private long id;
    private CategoryDTO category;
    private TopicDTO topic;
    private GenreDTO genre;
    private TagDTO tag;
    private String level;
    private String type;
    private String statement;
    private List<String> options;
    private String correctAnswer;
    private String playerAnswer;
}
