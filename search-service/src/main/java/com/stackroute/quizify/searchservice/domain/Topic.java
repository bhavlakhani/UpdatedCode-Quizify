package com.stackroute.quizify.searchservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Topic {
    @Id
    private long id;
    private String name;
    private String imageUrl;
}
