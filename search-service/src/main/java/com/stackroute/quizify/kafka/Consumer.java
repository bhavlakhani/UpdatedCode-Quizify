package com.stackroute.quizify.kafka;

import com.stackroute.quizify.dto.mapper.GameMapper;
import com.stackroute.quizify.dto.model.GameDTO;
import com.stackroute.quizify.searchservice.domain.Game;
import com.stackroute.quizify.searchservice.domain.Genres;
import com.stackroute.quizify.searchservice.domain.Topics;
import com.stackroute.quizify.searchservice.repository.GenreRepository;
import com.stackroute.quizify.searchservice.repository.TopicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Consumer {

    private Game recievedGame;
    private GenreRepository genreRepository;
    private TopicRepository topicRepository;
    private GameMapper gameMapper;


    @Autowired
    public Consumer(GenreRepository genreRepository, TopicRepository topicRepository, GameMapper gameMapper) {
        this.genreRepository = genreRepository;
        this.topicRepository = topicRepository;
        this.gameMapper = gameMapper;
    }

    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "game", groupId = "search-game-consumers", containerFactory = "kafkaListenerContainerFactory")
    public void receive(@Payload GameDTO payload) {
        recievedGame = this.gameMapper.gameDTOToGame(payload);
        logger.info("------------------------------------------------------------------------------------------------");
        logger.info("Game Received into Search : "+recievedGame);

        List<Game> newList;
        Topics topics;
        Genres genres;


        if (this.topicRepository.existsByName(payload.getTopic().getName()))
        {
            topics = this.topicRepository.findByName(payload.getTopic().getName());
            newList = topics.getGames();
            newList.add(recievedGame);
            topics.setGames(newList);
            this.topicRepository.save(topics);
        }
        else
        {
            topics = new Topics();
            newList = new ArrayList<>();
            if(this.topicRepository.findTopByOrderByIdDesc().isEmpty())
                topics.setId(1);
            else
                topics.setId(this.topicRepository.findTopByOrderByIdDesc().get().getId()+1);
            topics.setName(payload.getTopic().getName());
            topics.setImageUrl(payload.getImageUrl());
            newList.add(recievedGame);
            topics.setGames(newList);
            this.topicRepository.save(topics);
        }

        if (this.genreRepository.existsByName(payload.getGenre().getName()))
        {
            genres = this.genreRepository.findByName(payload.getGenre().getName());
            newList = genres.getGames();
            newList.add(recievedGame);
            genres.setGames(newList);
            this.genreRepository.save(genres);
        }
        else
        {
            genres = new Genres();
            newList = new ArrayList<>();
            if(this.genreRepository.findTopByOrderByIdDesc().isEmpty())
                genres.setId(1);
            else
                genres.setId(this.genreRepository.findTopByOrderByIdDesc().get().getId()+1);
            genres.setName(payload.getGenre().getName());
            genres.setImageUrl(payload.getImageUrl());
            newList.add(recievedGame);
            genres.setGames(newList);
            this.genreRepository.save(genres);
        }
    }
}
