package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends Neo4jRepository<User, Long> {
    
    @Query("MATCH (User) RETURN User")
    public List<User> getAllNodes();

    @Query("MATCH (u:User) WHERE u.id={userId} RETURN u")
    public User getNode(@Param("userId") long userId);

    @Query("CREATE (u:User) SET u.id={userId},u.name={userName},u.gender={gender} RETURN u")
    User createNode(long userId, String userName, String gender);

    @Query("MATCH (n:User) WHERE n.id={userId} DETACH DELETE n RETURN 'node deleted' ")
    User deleteNode(@Param("userId") long userId);

    @Query("MATCH (n:User) WHERE n.id={userId} SET n.userName={userName},n.gender={gender} RETURN n")
    User updateNode(@Param("userId") long userId, @Param("userName") String userName, @Param("gender") String gender);
}
