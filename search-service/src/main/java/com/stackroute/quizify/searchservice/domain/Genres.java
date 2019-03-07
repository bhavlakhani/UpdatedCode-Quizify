package com.stackroute.quizify.searchservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/*
 * This "Genre" class is used to create documents which will store genre names when searched.
 *
 * The Annotation "@Data" is used as a convenient shortcut annotation that bundles the features
 * of @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together:
 * In other words, @Data generates all the boilerplate that is normally associated with simple
 * POJOs (Plain Old Java Objects).
 *
 * The Annotation "@Id" is used to declare that the field "id" as the Primary Key which will be
 * Non-Null and Unique.
 */

@Document(collection="genres")
@Data
public class Genres {
    @Id
    private long id;
    private String name;
    private String imageUrl;
    private List<Game> games;
}
