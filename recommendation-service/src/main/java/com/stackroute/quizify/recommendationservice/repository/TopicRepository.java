package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.Topic;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface TopicRepository extends Neo4jRepository<Topic,Long> {


    @Query("MATCH p=(t:Topic) RETURN t")
    public List<Topic> getAllNodes();

    @Query("MATCH p=(t:Topic)-[r:is_type_of]->(c:Category) WHERE c.id={categoryId}  RETURN t")
    public List<Topic> getTopicsByCategory(long categoryId);
}
