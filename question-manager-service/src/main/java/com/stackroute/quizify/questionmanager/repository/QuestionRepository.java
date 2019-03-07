package com.stackroute.quizify.questionmanager.repository;

import com.stackroute.quizify.questionmanager.domain.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
 * This "QuestionRepository" interface is used for CRUD operations in MongoDB.
 *
 * In QuestionRepository interface we gave Question as the Document Type and String as the ID Type
 * for the document.
 *
 * The Annotation "@Repository" is used to indicate that the class provides the mechanism for
 * storage, retrieval, search, update and delete operation on objects.
 *
 * The Annotation "@Query" is used to give Custom Query for MongoDB for a Method.
 * After the Annotation the Custom Query has to be Specified in Parenthesis.
 *
 * The custom method "getQuestions" is used to get all Questions according to the given Category Name,
 * the given Topic Name and the given Level
 *
 * The custom method "getAllQuestions" is used to get all Questions according to the given Category Name,
 * the given Topic Name only
 *
 */

@Repository
public interface QuestionRepository extends MongoRepository<Question, Long> {

    Optional<Question> findTopByOrderByIdDesc();

    Question findById(long id);

    boolean existsById(long id);

    @Query("{ 'tag.name': '?0', 'level': '?1' }")
    List<Question> getQuestionsByTagByLevel(String tagName, String level);

    @Query("{ 'tag.name': '?0' }")
    List<Question> getQuestionsByTag(String tagName);

    @Query("{ 'topic.name': '?0' , 'level': '?1' }")
    List<Question> getQuestionsByTopicByLevel(String topicName, String level);

    @Query("{ 'topic.name': '?0' }")
    List<Question> getQuestionsByTopic(String topicName);

    @Query("{ 'genre.name': '?0' , 'level': '?1' }")
    List<Question> getQuestionsByGenreByLevel(String genreName, String level);

    @Query("{ 'genre.name': '?0' }")
    List<Question> getQuestionsByGenre(String genreName);

    @Query("{ 'topic.name': '?0', 'genre.name': '?1' , 'level': '?2' }")
    List<Question> getQuestionsByTopicByGenreByLevel(String topicName ,String genreName, String level);


}
