package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.Genre;
import com.stackroute.quizify.recommendationservice.domain.LikesGenre;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikesGenreRelationshipRepository extends Neo4jRepository<Genre, Long> {
    @Query("MATCH p=(User)-[r:LikesGenre]->(Genre) RETURN p")
    public List<LikesGenre> getAllRelationships();

    @Query("MATCH (p:User),(t:Genre) WHERE p.id={userId} and t.id={genreId} CREATE (p)-[q:LikesGenre]->(t) RETURN p,q,t")
    LikesGenre createRelationship(long userId, long genreId);

//    @Query("MATCH (p:User)-[r:LikesGenre]->(t:Genre) WHERE p.id={userId} and t.id={genreId} DELETE r RETURN 'relationship deleted' ")
//    LikesGenre deleteRelationship(@Param("userId") Long userId, @Param("genreId") long genreId);
}
