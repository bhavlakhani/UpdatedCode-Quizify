package com.stackroute.quizify.kafka;

import com.stackroute.quizify.dto.mapper.*;
import com.stackroute.quizify.dto.model.GameDTO;
import com.stackroute.quizify.dto.model.UserDTO;
import com.stackroute.quizify.recommendationservice.domain.*;
import com.stackroute.quizify.recommendationservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Consumer {

    private GamesService gamesService;
    private UserService userService;
    private PlayedRelationshipService playedRelationshipService;

    private UserMapper userMapper;
    private GameMapper gameMapper;
    private SinglePlayerMapper singlePlayerMapper;
    @Autowired
    private TopicMapper topicMapper;
    @Autowired
    private GenreMapper genreMapper;

    private Game game = new Game();
    private User user =new User();
    private SinglePlayer singlePlayer =new SinglePlayer();
    private List<Topic> topics;
    private List<Genre> genres;

    @Autowired
    public Consumer(GamesService gamesService, UserService userService, PlayedRelationshipService playedRelationshipService, UserMapper userMapper,GameMapper gameMapper,SinglePlayerMapper singlePlayerMapper) {
        this.gamesService = gamesService;
        this.userService = userService;
        this.playedRelationshipService = playedRelationshipService;
        this.gameMapper=gameMapper;
        this.userMapper=userMapper;
        this.singlePlayerMapper=singlePlayerMapper;
    }

    @KafkaListener(topics = "game", groupId = "recommendation-game-consumer", containerFactory = "kafkaListenerGameContainerFactory")
    public void receiveGame(@Payload GameDTO payload) {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Game Received To Recommendation : ");
        System.out.println(payload);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");

        this.game =gameMapper.gameDTOToGame(payload);

//        game.setId(payload.getId());
//        game.setName(payload.getName());
//        game.setRules(payload.getRules());
//        game.setTimeDuration(payload.getTimeDuration());
//        game.setPlayCount(payload.getPlayCount());
//        game.setImageUrl(payload.getImageUrl());
//        game.setLevel(payload.getLevel());
//        game.setLiked(payload.getLiked());
//        game.setNumOfQuestion(payload.getNumOfQuestion());
////        game.setCategory(payload.getCategory());
//        game.setGenre(genreMapper.genreDTOToGenre(payload.getGenre()));
//        game.setTopic(topicMapper.topicDTOToTopic(payload.getTopic()));
////        game.setTag(payload.getTag());
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(game.toString());

        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        gamesService.create(game);

    }

    @KafkaListener(topics = "user", groupId = "recommendation-user-consumer", containerFactory = "kafkaListenerUserContainerFactory")
    public void receiveUser(@Payload UserDTO payload) {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("User Received To Recommendation : ");
        System.out.println(payload);
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        this.user = this.userMapper.userDTOToUser(payload);

//        user.setId(payload.getId());
//        user.setName(payload.getName());
//        user.setGender(payload.getGender());
//        ListIterator<TopicDTO> topicsIterator = payload.getTopics().listIterator();
//        while(topicsIterator.hasNext()){
//            Topic topic=topicMapper.topicDTOToTopic(topicsIterator.next());
//            topics.add(topic);
//        }
//        ListIterator<GenreDTO> genresIterator = payload.getGenres().listIterator();
//        while(genresIterator.hasNext()){
//            Genre genre=genreMapper.genreDTOToGenre(genresIterator.next());
//            genres.add(genre);
//        }
//        user.setTopics(topics);
//        user.setGenres(genres);
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------\n"+ user.toString());

        userService.create(user);
    }

//    @KafkaListener(topics = "singlePlayer", groupId = "recommendation-single-player-consumer", containerFactory = "kafkaListenerSinglePlayerContainerFactory")
//    public void receiveSinglePlayer(@Payload SinglePlayerDTO payload) {
//        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
//        System.out.println("SinglePlayer Received To Recommendation : ");
//        System.out.println(payload);
//        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
//        this.singlePlayer=this.singlePlayerMapper.singlePlayerDTOToSinglePlayer(payload);
//        singlePlayer.setGameId(payload.getGame().getId());
//        singlePlayer.setUserId(payload.getUser().getId());
//
//        System.out.println(" gameId  "+singlePlayer.getGameId()  +"  userId   "+singlePlayer.getUserId());
//
//        playedRelationshipService.createRelationship(singlePlayer);
//    }

}

