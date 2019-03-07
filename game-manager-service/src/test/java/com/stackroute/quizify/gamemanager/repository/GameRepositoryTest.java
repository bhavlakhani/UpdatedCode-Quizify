//package com.example.stackroute.gamemanager.repository;
//
//import com.example.stackroute.gamemanager.domain.*;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.Assert.*;
//
//
//@RunWith(SpringRunner.class)
//@DataMongoTest
//public class GameRepositoryTest {
//
//    @Autowired
//    GameRepository gameRepository;
//
//
//
//   private Topic topic;
//    private Admin admin;
//    private Game game;
//    private Category category;
//    private Question question;
//
//
//
//    @Before
//    public void setUp() throws Exception {
//
//
//        this.admin = new Admin();
//        this.admin.setId("1");
//        this.admin.setName("admin1");
//
//        this.topic = new Topic();
//        this.topic.setName("topic1");
//        this.topic.setImageUrl("a.png");
//        this.topic.setAdmin(this.admin);
//        List<Topic> subtopics = new ArrayList<>();
//        Topic topic1 = new Topic();
//        subtopics.add(topic1);
//        this.topic.setSubTopics(subtopics);
//
//
//        this.category = new Category();
//        this.category.setName("category1");
//        this.category.setImageUrl(".png");
//        this.category.setTimeStamp((int)System.currentTimeMillis());
//        this.category.setAdmin(this.admin);
//
//
//
//        this.question = new Question();
//        this.question.setId("q1");
//        this.question.setCategory(this.category);
//        this.question.setLevel("easy");
//        this.question.setTimeStamp((int)System.currentTimeMillis());
//        this.question.setAdmin(this.admin);
//        this.question.setType("MCQ");
//        this.question.setStatement("");
//        this.question.setAnswer("any Question?");
//
//        List<String> options = new ArrayList<>();
//        options.add("A");
//        options.add("B");
//        options.add("C");
//        options.add("D");
//        this.question.setOptions(options);
//        this.question.setTopic(this.topic);
//
//        List<Question> questions = new ArrayList<>();
//        questions.add(this.question);
//
//        this.game = new Game();
//        this.game.setId("g1");
//        this.game.setName("game1");
//        this.game.setTopic(this.topic);
//        this.game.setCategory(this.category);
//        this.game.setAdmin(this.admin);
//        this.game.setLevel("medium");
//        this.game.setQuestions(questions);
//        this.game.setGenre("movies");
//        this.game.setLiked(10);
//        this.game.setPlayCount(5);
//        this.game.setNumOfQuestion(10);
//        this.game.setPlayed(2);
//        this.game.setTag("movies/TV Shows");
//        this.game.setTimestamp(10);
//        this.game.setRules("you cannot cheat during quiz");
//
//
//
//    }
//
//    @Test
//    public void saveGameTest(){
//
//        Game savedGame = this.gameRepository.save(this.game);
//        assertEquals(this.game, savedGame);
//
//    }
//
//    @Test
//    public void updateGameTest(){
//
//        Game savedGame = this.gameRepository.save(game);
//
//        Game updatedGame = new Game();
//        updatedGame.setId("g2");
//        updatedGame.setName("game2");
//        updatedGame.setTopic(this.topic);
//        updatedGame.setCategory(this.category);
//        updatedGame.setAdmin(this.admin);
//        updatedGame.setLevel("medium");
//
//        List<Question> questions = new ArrayList<>();
//        questions.add(this.question);
//        updatedGame.setQuestions(questions);
//        updatedGame.setGenre("movies");
//        updatedGame.setLiked(10);
//        updatedGame.setPlayCount(5);
//        updatedGame.setNumOfQuestion(10);
//        updatedGame.setPlayed(2);
//        updatedGame.setTag("movies/TV Shows");
//        updatedGame.setTimestamp(10);
//        updatedGame.setRules("you cannot cheat during quiz");
//
//        Game saveupdateGame = gameRepository.save(updatedGame);
//        assertNotEquals(savedGame, saveupdateGame);
//
//    }
//
//    @Test
//    public void deleteGameTest(){
////        Game savedGames = new Game();
////       if(savedGames = this.gameRepository.existsById(this.game.getId()))
//
//        this.gameRepository.delete(this.game);
//       //Game deletedGame = this.gameRepository.findById(this.game.getId()).get();
//        System.out.println(this.gameRepository.findById(this.game.getId()).isEmpty());
//       assertTrue(this.gameRepository.findById(this.game.getId()).isEmpty());
//
////        assertNull(deletedGame);
//    }
//
//    @Test
//    public void getAllGamesTest(){
//
//        Game savedGame1 = this.gameRepository.save(this.game);
//
//        this.game = new Game();
//        this.game.setId("g1");
//        this.game.setName("game1");
//        this.game.setTopic(this.topic);
//        this.game.setCategory(this.category);
//        this.game.setAdmin(this.admin);
//        this.game.setLevel("medium");
//
//        List<Question> questions = new ArrayList<>();
//        questions.add(question);
//        this.game.setQuestions(questions);
//        this.game.setGenre("movies");
//        this.game.setLiked(10);
//        this.game.setPlayCount(5);
//        this.game.setNumOfQuestion(10);
//        this.game.setPlayed(2);
//        this.game.setTag("movies/TV Shows");
//        this.game.setTimestamp(10);
//        this.game.setRules("you cannot cheat during quiz");
//
//        Game savedGame2 = gameRepository.save(this.game);
//        List<Game> gameList = new ArrayList<>();
//        gameList = this.gameRepository.getAllGames(this.game.getGenre(), this.game.getTopic().getName());
//
//        assertTrue(gameList.contains(savedGame1));
//        assertTrue(gameList.contains(savedGame2));
//
//    }
//    }
