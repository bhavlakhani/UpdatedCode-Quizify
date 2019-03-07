package com.stackroute.quizify.recommendationservice.serviceImpl;


import com.stackroute.quizify.recommendationservice.domain.Genre;
import com.stackroute.quizify.recommendationservice.domain.LikesGenre;
import com.stackroute.quizify.recommendationservice.domain.User;
import com.stackroute.quizify.recommendationservice.repository.LikesGenreRelationshipRepository;
import com.stackroute.quizify.recommendationservice.service.LikesGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ListIterator;

@Service
public class LikesGenreServiceImpl implements LikesGenreService {

    private LikesGenreRelationshipRepository likesGenreRelationshipRepository;

    @Autowired
    public LikesGenreServiceImpl(LikesGenreRelationshipRepository likesGenreRelationshipRepository) {
        this.likesGenreRelationshipRepository = likesGenreRelationshipRepository;
    }


    @Override
    public List<LikesGenre> getAllRelationships() {
        return likesGenreRelationshipRepository.getAllRelationships();
    }

    @Override
    public String createRelationship(User user) {
        long userId = user.getId();
        List<Genre> genres = user.getGenres();
        ListIterator<Genre> genresIterator = genres.listIterator();
        while(genresIterator.hasNext()){
            Genre genre=genresIterator.next();
            System.out.println(genre.toString());
            long genreId=genre.getId();
            System.out.println("userId: "+userId+"genreId: "+genreId);
            likesGenreRelationshipRepository.createRelationship(userId,genreId);
        }
        return " "; //change as required
    }
}
