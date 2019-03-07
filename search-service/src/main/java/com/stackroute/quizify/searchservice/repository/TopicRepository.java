package com.stackroute.quizify.searchservice.repository;

import com.stackroute.quizify.searchservice.domain.Topics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/*
 * This "TopicRepository" interface is used for CRUD operations in MongoDB.
 *
 * In TopicRepository interface we gave Genre as the Document Type and String as the ID Type
 * for the document.
 *
 * The Annotation "@Repository" is used to indicate that the class provides the mechanism for
 * storage search operation on objects.
 *
 * The Annotation "@Query" is used to give Custom Query for MongoDB for a Method.
 * After the Annotation the Custom Query has to be Specified in Parenthesis.
 *
 */

@Repository
public interface TopicRepository extends MongoRepository<Topics,Long> {
//    List<Topic> searchByTopicName(String topicName);

    @Query("{ name: { $regex: '^?0', $options: 'i'} }")
    List<Topics> searchByTopicAlphabet(String topicName);

    boolean existsByName(String genreName);

    Topics findByName(String topicName);

    Optional<Topics> findTopByOrderByIdDesc();
}
