package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.Played;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface PlayedRelationshipRepository extends Neo4jRepository<Played,String> {

    @Query("MATCH p=(User)-[r:Played]->(Game) RETURN p")
    public List<Played> getAllRelationships();

    @Query("MATCH (p:User),(t:Game) WHERE p.id={userId} and t.id={gameId} CREATE (p)-[q:Played]->(t) RETURN p,q,t")
    Played createRelationship(long userId,long gameId);

//    @Query("MATCH (p:User)-[r:Played]->(t:Game) WHERE p.id={userId} and t.id={gameId} DELETE r RETURN 'relationship deleted' ")
//    Played deleteRelationship(@Param("userId") Long userId, @Param("gameId") long gameId);

}
