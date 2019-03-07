package com.stackroute.quizify.userregistrationservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Genre {
    @Id
    private Long id;
    private String name;
    private String imageUrl;
}