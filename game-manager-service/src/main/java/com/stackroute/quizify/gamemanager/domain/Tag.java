package com.stackroute.quizify.gamemanager.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Tag {
    @Id
    private long id;
    private String name;
    private String imageUrl;
}
