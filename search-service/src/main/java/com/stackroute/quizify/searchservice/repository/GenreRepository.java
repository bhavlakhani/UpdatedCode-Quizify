package com.stackroute.quizify.searchservice.repository;

import com.stackroute.quizify.searchservice.domain.Genres;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/*
 * This "GenreRepository" interface is used for CRUD operations in MongoDB.
 *
 * In GenreRepository interface we gave Genre as the Document Type and String as the ID Type
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
public interface GenreRepository extends MongoRepository<Genres,Long> {

//    List<Genre> searchByGenreName(String genreName);

    @Query("{ name: { $regex: '^?0', $options: 'i'} }")
    List<Genres> searchByGenreAlphabet(String genreName);

    boolean existsByName(String genreName);

    Genres findByName(String genreName);

    Optional<Genres> findTopByOrderByIdDesc();
}
