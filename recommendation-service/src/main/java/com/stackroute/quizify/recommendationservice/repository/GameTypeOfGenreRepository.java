package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.GameTypeOfGenre;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameTypeOfGenreRepository extends Neo4jRepository<GameTypeOfGenre, Long> {
    @Query("MATCH p=(Game)-[r:game_type_of]->(Genre) RETURN p")
    public List<GameTypeOfGenre> getAllRelationships();

    @Query("MATCH (p:Game),(t:Genre) WHERE p.id={gameId} and t.id={genreId} CREATE (p)-[q:game_type_of]->(t) RETURN p,q,t")
    GameTypeOfGenre createRelationship(long gameId, long genreId);
}