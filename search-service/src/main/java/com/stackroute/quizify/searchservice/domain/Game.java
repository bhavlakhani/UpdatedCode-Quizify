package com.stackroute.quizify.searchservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

/*
 * This "Game" class is used to get game names from our message bus(Kafka).
 *
 * The Annotation "@Data" is used as a convenient shortcut annotation that bundles the features
 * of @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together:
 * In other words, @Data generates all the boilerplate that is normally associated with simple
 * POJOs (Plain Old Java Objects).
 *
 * The Annotation "@Id" is used to declare that the field "id" as the Primary Key which will be
 * Non-Null and Unique.
 */

@Data
public class Game {
    @Id
    private long id;
    private String name;
    private Category category;
    private Topic topic;
    private Genre genre;
    private String level;
    private String imageUrl;
    private List<String> rules;
    private long timeDuration;
    private int liked;
    private int playCount;
    private int numOfQuestion;
}
