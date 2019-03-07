package com.stackroute.quizify.dto.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class GenreDTO {
    @Id
    private long id;
    private String name;
    private String imageUrl;
}
