//package com.example.stackroute.gamemanager.service;
//
//import com.example.stackroute.gamemanager.domain.*;
//import GameAlreadyExists;
//import GameNotFound;
//import GameRepository;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
//
//
//public class GameServiceimplTest  {
//
//
//    @Mock
//    private GameRepository gameRepository;
//
//
//   private Topic topic;
//    private Admin admin;
//    private Game game;
//    private Category category;
//   private Question question;
//
//
//
//    @InjectMocks
//   private GameServiceimpl gameServiceimpl;
//
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
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
//    }
//
//    @After
//    public void tearDown() throws Exception {
//
//        this.question = null;
//        this.topic = null;
//        this.category = null;
//        this.admin = null;
//        this.game = null;
//
//    }
//
//
//    @Test
//    public void saveGameTestSuccess() throws GameAlreadyExists {
//
//        when(this.gameRepository.existsById((String)any())).thenReturn(false);
//        when(this.gameRepository.save((Game)any())).thenReturn(this.game);
//        Game savedGame = this.gameServiceimpl.saveGame(this.game);
//        assertEquals(this.game, savedGame);
//
//        verify(this.gameRepository, times(1)).existsById((String)any());
//        verify(this.gameRepository, times(1)).save((Game) any());
//    }
//
//
//    @Test
//    public void deleteGameTestSuccess() throws GameNotFound {
//
//        when(this.gameRepository.existsById((String)any())).thenReturn(true);
//        Game gameDelete = this.gameServiceimpl.deleteGame(this.game);
//        assertEquals(this.game, gameDelete);
//
//        verify(this.gameRepository, times(1)).existsById((String)any());
//        verify(this.gameRepository, times(1)).delete((Game) any());
//
//    }
//
//    @Test
//    public void updateGameTestSuccess() throws GameNotFound{
//
//        when(this.gameRepository.existsById((String)any())).thenReturn(true);
//        when(this.gameRepository.save((Game) any())).thenReturn(this.game);
//
//        Game updatedGame = this.gameServiceimpl.updateGame(this.game);
//        assertEquals(this.game, updatedGame);
//
//        verify(this.gameRepository, times(1)).existsById((String)any());
//        verify(this.gameRepository, times(1)).save((Game) any());
//    }
//
//    @Test
//    public void getAllGamesTestSuccess() throws GameNotFound{
//        this.game = new Game();
//        this.game.setId("g1");
//        this.game.setName("game1");
//        this.game.setTopic(this.topic);
//        this.game.setCategory(this.category);
//        this.game.setAdmin(this.admin);
//        this.game.setLevel("medium");
//        List<Question> questions = new ArrayList<>();
//        questions.add(this.question);
//
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
//        List<Game> game = new ArrayList<>();
//        game.add(this.game);
//
//
//        when(this.gameRepository.getAllGames((String)any(), (String)any())).thenReturn(game);
//
//        List<Game> gameList= this.gameServiceimpl.getAllGames(this.game.getGenre(), this.topic.getName());
//
//        assertFalse(gameList.isEmpty());
//
//        verify(this.gameRepository, times(1)).getAllGames((String)any(), (String)any());
//
//    }
//}