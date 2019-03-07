package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.LikesGame;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesGameRelationshipRepository extends Neo4jRepository<LikesGame, Long> {
    @Query("MATCH p=(User)-[r:LikesGame]->(Game) RETURN p")
    public List<LikesGame> getAllRelationships();

    @Query("MATCH (p:User),(t:Game) WHERE p.id={userId} and t.id={gameId} CREATE (p)-[q:LikesGame]->(t) RETURN p,q,t")
    LikesGame createRelationship(@Param("userId") long userId, @Param("gameId") long gameId);

    @Query("MATCH (p:User)-[r:LikesGame]->(t:Game) WHERE p.id={userId} and t.id={gameId} DELETE r RETURN 'relationship deleted' ")
    LikesGame deleteRelationship(@Param("userId") long userId, @Param("gameId") long gameId);
}
