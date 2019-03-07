package com.stackroute.quizify.recommendationservice.repository;

import com.stackroute.quizify.recommendationservice.domain.Category;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface CategoryRepository extends Neo4jRepository<Category,Long> {

    @Query("MATCH (Category) RETURN Category")
    public List<Category> getAllNodes();
}
