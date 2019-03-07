package com.stackroute.quizify.recommendationservice.serviceImpl;

import com.stackroute.quizify.recommendationservice.domain.Game;
import com.stackroute.quizify.recommendationservice.repository.GamesRepository;
import com.stackroute.quizify.recommendationservice.service.GameIsATopicService;
import com.stackroute.quizify.recommendationservice.service.GameTypeOfGenreService;
import com.stackroute.quizify.recommendationservice.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesServiceImpl implements GamesService {

    GamesRepository gamesRepository;

    @Autowired
    private GameIsATopicService gameIsATopicService;

    @Autowired
    private GameTypeOfGenreService gameTypeOfGenreService;
    @Autowired
    public GamesServiceImpl(GamesRepository gamesRepository) {
        this.gamesRepository = gamesRepository;
    }

    @Override
    public List<Game> getAll() {
        return gamesRepository.getAllNodes();
    }

    @Override
    public Game getone(long gamesId) {
        return gamesRepository.getNode(gamesId);
    }

    @Override
    public Game create(Game game) {
        long id= game.getId();
        String name= game.getName();
        String level= game.getLevel();
        String imageUrl= game.getImageUrl();
        int numOfQuestion= game.getNumOfQuestion();
        int timeDuration= game.getTimeDuration();
        int liked= game.getLiked();
        List<String> rules= game.getRules();
        int playcount= game.getPlayCount();
        Game game1 =gamesRepository.createNode(id,name,playcount,level,imageUrl,numOfQuestion,timeDuration,liked,rules);
        gameIsATopicService.createRelationship(game);
        gameTypeOfGenreService.createRelationship(game);
        return game1;
    }

    @Override
    public Game delete(long gamesId) {
        return gamesRepository.deleteNode(gamesId);
    }

    @Override
    public Game update(Game game) {
        long id= game.getId();
        String name= game.getName();
        return gamesRepository.updateNode(id,name);
    }

    @Override
    public List<Game> getMostPlayed() {
        return gamesRepository.getMostPlayed();
    }
}
