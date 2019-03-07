package com.stackroute.quizify.kafka.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/*
 * This "Question" class is used to create documents question which will be saved in QuestionSet.
 *
 * The Annotation "@Document" is used to declare the collection where the documents of
 * "Question" class will be saved.
 *
 * The Annotation "@Data" is used as a convenient shortcut annotation that bundles the features
 * of @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together:
 * In other words, @Data generates all the boilerplate that is normally associated with simple
 * POJOs (Plain Old Java Objects).
 *
 * The Annotation "@Id" is used to declare that the field "id" as the Primary Key which will be
 * Non-Null and Unique.
 *
 * The Category Field will contain the Object of Category class which will define the category
 * for which this question is created.
 *
 * The Topic Field will contain the Object of Topic class which will define the topic
 * for which this question is created.
 *
 * The Field "type" will contain question Type like MCQ/True-False etc.
 *
 * The Field "level" will contain question Difficulty Level like easy/medium/hard etc.
 *
 * The Field "statement" will contain actual Question Statement (only the question itself).
 *
 * The Field "options" is a List of String which will contain all the options for that question.
 *
 * The Field "answer" will contain only the Correct Answer.
 *
 * The Field "admin" is used to store the data of the last Admin who Edited this category document.
 *
 * The Field "timeStamp" is used to store the Timestamp of last time the document is edited.
 */
@Data
public class Question {
    @Id
    private long id;
    private Category category;
    private Topic topic;
    private Genre genre;
    private Tag tag;
    private String level;
    private String type;
    private String statement;
    private List<String> options;
    private String correctAnswer;
    private String playerAnswer;
}
