//package com.example.stackroute.gamemanager.controller;
//
//import com.example.stackroute.gamemanager.domain.*;
//import GameAlreadyExists;
//import GameNotFound;
//import com.example.stackroute.gamemanager.service.GameServiceimpl;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class GameControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private GameServiceimpl gameServiceimpl;
//
//    @InjectMocks
//    private GameController gameController;
//
//    private  Game game;
//    private Admin admin;
//    private Category category;
//    private Topic topic;
//    private Question question;
//    private List<Question> questions;
//    private List<Game> game;
//
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(this.gameController).build();
//
//        /**
//         * Dummy Data For Admin Class
//         */
//        this.admin = new Admin();
//        this.admin.setId("101");
//        this.admin.setName("Kaustav");
//
//        /**
//         * Dummy Data For Category Class
//         */
//        this.category = new Category();
//        this.category.setName("Entertainment");
//        this.category.setImageUrl("https://www.gudstory.com/wp-content/uploads/2018/10/Entertainment-1.jpg");
//        this.category.setTimeStamp((int)System.currentTimeMillis());
//        this.category.setAdmin(this.admin);
//        /**
//         * Dummy Data For Topic Class
//         */
//        this.topic = new Topic();
//        this.topic.setName("Movies");
//        this.topic.setImageUrl("https://boygeniusreport.files.wordpress.com/2016/03/movies-tiles.jpg?quality=98&strip=all");
//        this.topic.setTimeStamp((int)System.currentTimeMillis());
//        this.topic.setAdmin(this.admin);
//        /**
//         * Dummy Data For Topic Class
//         */
//        this.topic = new Topic();
//        this.topic.setName("TV-Shows");
//        this.topic.setImageUrl("http://i-vrox.com/wp-content/uploads/2018/06/series-2.jpg");
//        this.topic.setTimeStamp((int)System.currentTimeMillis());
//        this.topic.setAdmin(this.admin);
//        /**
//         * Dummy Data For Question Class
//         */
//        this.question = new Question();
//        this.question.setId("1234567890");
//        this.question.setCategory(this.category);
//        this.question.setTopic(this.topic);
//        this.question.setLevel("easy");
//        this.question.setType("mcq");
//        this.question.setStatement("How many oscars did the Titanic movie got?");
//        List<String> options = new ArrayList<>();
//        options.add("10");
//        options.add("11");
//        options.add("9");
//        options.add("8");
//        this.question.setOptions(options);
//        this.question.setAnswer("11");
//        this.question.setTimeStamp((int)System.currentTimeMillis());
//        this.question.setAdmin(this.admin);
//        /**
//         * Array List of Question
//         */
//        this.questions = new ArrayList<>();
//       questions.add(question);
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
//        List<Game> game = new ArrayList<>();
//        game.add(game);
//
//
//    }
//    @After
//    public void tearDown() throws Exception {
//        this.questions = null;
//        this.question = null;
//        this.topic = null;
//        this.topic = null;
//        this.category = null;
//        this.admin = null;
//    }
//
//    @Test
//    public void saveGameSuccessTest() throws Exception {
//        when(this.gameServiceimpl.saveGame((Game)any())).thenReturn(this.game);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/game/game")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.game)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void saveGameFailureTest() throws Exception {
//        when(this.gameServiceimpl.saveGame((Game)any())).thenThrow(GameAlreadyExists.class);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/game/game")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.game)))
//                .andExpect(MockMvcResultMatchers.status().isConflict())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//
//
//    @Test
//    public void updateGameSuccessTest() throws Exception {
//        when(this.gameServiceimpl.updateGame((Game) any())).thenReturn(this.game);
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/game/game")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.game)))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andDo(MockMvcResultHandlers.print());
//
//    }
//
//    @Test
//    public void updateGameFailureTest() throws Exception {
//        when(this.gameServiceimpl.updateGame((Game) any())).thenThrow(GameNotFound.class);
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/game/game")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.game)))
//                .andExpect(MockMvcResultMatchers.status().isConflict())
//                .andDo(MockMvcResultHandlers.print());
//    }
//    @Test
//    public void deleteGameSuccessTest() throws Exception {
//        when(this.gameServiceimpl.deleteGame((Game) any())).thenReturn(this.game);
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/game/game")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.game)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void deleteGameFailureTest() throws Exception {
//        when(this.gameServiceimpl.deleteGame((Game) any())).thenThrow(GameNotFound.class);
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/game/game")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.game)))
//                .andExpect(MockMvcResultMatchers.status().isConflict())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getAllGamesSuccessTest() throws Exception {
//        when(this.gameServiceimpl.getAllGames((String) any(), (String) any())).thenReturn(this.game);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/game/{genre}/{topic}", this.game.getGenre(), this.game.getTopic().getName())
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.game)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getAllGamesFailureTest() throws Exception {
//
//        when(this.gameServiceimpl.getAllGames((String) any(), (String) any())).thenThrow(GameNotFound.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/game/{genre}/{topic}", this.game.getGenre(), this.game.getTopic().getName())
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.game)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    private static String asJsonString(final Object obj) {
//        try {
//            return new ObjectMapper().writeValueAsString(obj);
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}