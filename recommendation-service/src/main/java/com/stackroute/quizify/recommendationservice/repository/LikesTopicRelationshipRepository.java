package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.LikesTopic;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesTopicRelationshipRepository extends Neo4jRepository<LikesTopic,String> {

    @Query("MATCH p=(User)-[r:LikesTopic]->(Topic) RETURN p")
    public List<LikesTopic> getAllRelationships();

    @Query("MATCH (p:User),(t:Topic) WHERE p.id={userId} and t.id={topicId} CREATE (p)-[q:LikesTopic]->(t) RETURN p,q,t")
    List<LikesTopic> createRelationship(long userId,long topicId);

//    @Query("MATCH (p:User)-[r:LikesTopic]->(t:Topic) WHERE p.id={userId} and t.id={topicId} DELETE r RETURN 'relationship deleted' ")
//    LikesTopic deleteRelationship(@Param("userId") Long userId, @Param("topicId") long topicId);
}
