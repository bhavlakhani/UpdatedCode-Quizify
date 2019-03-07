//package com.stackroute.quizify.questionmanager.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.quizify.questionmanager.exception.NoQuestionFoundException;
//import com.stackroute.quizify.questionmanager.exception.QuestionAlreadyExistsException;
//import com.stackroute.quizify.questionmanager.exception.QuestionDoesNotExistException;
//import com.stackroute.quizify.questionmanager.service.QuestionService;
//import com.stackroute.quizify.kafka.domain.Admin;
//import Category;
//import Question;
//import Topic;
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
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class QuestionControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private QuestionService questionService;
//
//    @InjectMocks
//    private QuestionController questionController;
//
//    private Admin admin;
//    private Category category;
//    private Topic topicMovies;
//    private Topic topicTvShows;
//    private Question question;
//    private List<Question> questions;
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(this.questionController).build();
//
//        /**
//         * Dummy Data For Admin Class
//         */
//        this.admin = new Admin();
//        this.admin.setId(101);
//        this.admin.setName("Kaustav");
//
//        /**
//         * Dummy Data For Category Class
//         */
//        this.category = new Category();
//        this.category.setId(202);
//        this.category.setName("Entertainment");
//        this.category.setImageUrl("https://www.gudstory.com/wp-content/uploads/2018/10/Entertainment-1.jpg");
//        this.category.setTimeStamp(""+System.currentTimeMillis());
//        this.category.setAdmin(this.admin);
//        /**
//         * Dummy Data For Topic Class
//         */
//        this.topicMovies = new Topic();
//        this.topicMovies.setId(303);
//        this.topicMovies.setName("Movies");
//        this.topicMovies.setImageUrl("https://boygeniusreport.files.wordpress.com/2016/03/movies-tiles.jpg?quality=98&strip=all");
//        this.topicMovies.setTimeStamp(""+System.currentTimeMillis());
//        this.topicMovies.setAdmin(this.admin);
//        /**
//         * Dummy Data For Topic Class
//         */
//        this.topicTvShows = new Topic();
//        this.topicTvShows.setId(404);
//        this.topicTvShows.setName("TV-Shows");
//        this.topicTvShows.setImageUrl("http://i-vrox.com/wp-content/uploads/2018/06/series-2.jpg");
//        this.topicTvShows.setTimeStamp(""+System.currentTimeMillis());
//        this.topicTvShows.setAdmin(this.admin);
//        /**
//         * Dummy Data For Question Class
//         */
//        this.question = new Question();
//        this.question.setId(1234567890);
//        this.question.setCategory(this.category);
//        this.question.setTopic(this.topicMovies);
//        this.question.setTag("Basic");
//        this.question.setGenre("All");
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
//        this.question.setTimeStamp(""+System.currentTimeMillis());
//        this.question.setAdmin(this.admin);
//        /**
//         * Empty List of Question
//         */
//        this.questions = new ArrayList<>();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        this.questions = null;
//        this.question = null;
//        this.topicTvShows = null;
//        this.topicMovies = null;
//        this.category = null;
//        this.admin = null;
//    }
//
//    @Test
//    public void saveQuestionSuccessTest() throws Exception {
//        when(this.questionService.addNewQuestion((Question)any())).thenReturn(this.question);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/questions/question")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.question)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void saveQuestionFailureTest() throws Exception {
//        when(this.questionService.addNewQuestion((Question)any())).thenThrow(QuestionAlreadyExistsException.class);
//        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/questions/question")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.question)))
//                .andExpect(MockMvcResultMatchers.status().isConflict())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void updateQuestionSuccessTest() throws Exception {
//        when(this.questionService.updateQuestion((Question)any())).thenReturn(this.question);
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/questions/question")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.question)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void updateQuestionFailureTest() throws Exception {
//        when(this.questionService.updateQuestion((Question)any())).thenThrow(QuestionDoesNotExistException.class);
//        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/questions/question")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.question)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void removeQuestionSuccessTest() throws Exception {
//        when(this.questionService.removeQuestion((Question)any())).thenReturn(this.question);
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/questions/question")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.question)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void removeQuestionFailureTest() throws Exception {
//        when(this.questionService.removeQuestion((Question)any())).thenThrow(QuestionDoesNotExistException.class);
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/questions/question")
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.question)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
////  -------------------------------------Get Questions by Tag
//    @Test
//    public void getQuestionsByTagByLevelSuccessTest() throws Exception {
//        this.questions.add(this.question);
//        String tag = this.question.getTag();
//        String level = this.question.getLevel();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByTagByLevel((String) any(), (String) any(), anyInt())).thenReturn(this.questions);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/tag/{tag}/{level}/{numberOfQuestions}", tag, level, numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getQuestionsByTagByLevelFailureTest() throws Exception {
//        String tag = this.question.getTag();
//        String level = this.question.getLevel();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByTagByLevel((String) any(), (String) any(), anyInt())).thenThrow(NoQuestionFoundException.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/tag/{tag}/{level}/{numberOfQuestions}", tag, level, numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getQuestionsByTagSuccessTest() throws Exception {
//        this.questions.add(this.question);
//        String tag = this.question.getTag();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByTag((String) any(), anyInt())).thenReturn(this.questions);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/tag/{tag}/{numberOfQuestions}", tag, numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getQuestionsByTagFailureTest() throws Exception {
//        String tag = this.question.getTag();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByTag((String) any(), anyInt())).thenThrow(NoQuestionFoundException.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/tag/{tag}/{numberOfQuestions}", tag, numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getAllQuestionsByTagSuccessTest() throws Exception {
//        this.questions.add(this.question);
//        String tag = this.question.getTag();
//        when(this.questionService.getAllQuestionsByTag((String) any())).thenReturn(this.questions);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/tag/{tag}", tag)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getAllQuestionsByTagFailureTest() throws Exception {
//        String tag = this.question.getTag();
//        when(this.questionService.getAllQuestionsByTag((String) any())).thenThrow(NoQuestionFoundException.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/tag/{tag}", tag)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
////    ---------------------------------------------Get Questions by Topic
//
//    @Test
//    public void getQuestionsByTopicByLevelSuccessTest() throws Exception {
//        this.questions.add(this.question);
//        Topic topic = this.question.getTopic();
//        String level = this.question.getLevel();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByTopicByLevel((String) any(), (String) any(), anyInt())).thenReturn(this.questions);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/topic/{topicName}/{level}/{numberOfQuestions}", topic.getName(), level, numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getQuestionsByTopicByLevelFailureTest() throws Exception {
//        Topic topic = this.question.getTopic();
//        String level = this.question.getLevel();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByTopicByLevel((String) any(), (String) any(), anyInt())).thenThrow(NoQuestionFoundException.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/topic/{topicName}/{level}/{numberOfQuestions}", topic.getName(), level, numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getQuestionsByTopicSuccessTest() throws Exception {
//        this.questions.add(this.question);
//        Topic topic = this.question.getTopic();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByTopic((String) any(), anyInt())).thenReturn(this.questions);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/topic/{topicName}/{numberOfQuestions}", topic.getName(), numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getQuestionsByTopicFailureTest() throws Exception {
//        Topic topic = this.question.getTopic();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByTopic((String) any(), anyInt())).thenThrow(NoQuestionFoundException.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/topic/{topicName}/{numberOfQuestions}", topic.getName(), numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getAllQuestionsByTopicSuccessTest() throws Exception {
//        this.questions.add(this.question);
//        Topic topic = this.question.getTopic();
//        when(this.questionService.getAllQuestionsByTopic((String) any())).thenReturn(this.questions);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/topic/{topicName}", topic.getName())
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getAllQuestionsByTopicFailureTest() throws Exception {
//        Topic topic = this.question.getTopic();
//        when(this.questionService.getAllQuestionsByTopic((String) any())).thenThrow(NoQuestionFoundException.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/topic/{topicName}", topic.getName())
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
////    -----------------------------------------------------------------Get Questions By Genre
//
//    @Test
//    public void getQuestionsByGenreByLevelSuccessTest() throws Exception {
//        this.questions.add(this.question);
//        String genre = this.question.getGenre();
//        String level = this.question.getLevel();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByGenreByLevel((String) any(), (String) any(), anyInt())).thenReturn(this.questions);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/genre/{genre}/{level}/{numberOfQuestions}", genre, level, numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getQuestionsByGenreByLevelFailureTest() throws Exception {
//        String genre = this.question.getGenre();
//        String level = this.question.getLevel();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByGenreByLevel((String) any(), (String) any(), anyInt())).thenThrow(NoQuestionFoundException.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/genre/{genre}/{level}/{numberOfQuestions}", genre, level, numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getQuestionsByGenreSuccessTest() throws Exception {
//        this.questions.add(this.question);
//        String genre = this.question.getGenre();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByGenre((String) any(), anyInt())).thenReturn(this.questions);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/genre/{genre}/{numberOfQuestions}", genre, numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getQuestionsByGenreFailureTest() throws Exception {
//        String genre = this.question.getGenre();
//        int numberOfQuestions = 1;
//        when(this.questionService.getQuestionsByGenre((String) any(), anyInt())).thenThrow(NoQuestionFoundException.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/genre/{genre}/{numberOfQuestions}", genre, numberOfQuestions)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getAllQuestionsByGenreSuccessTest() throws Exception {
//        this.questions.add(this.question);
//        String genre = this.question.getGenre();
//        when(this.questionService.getAllQuestionsByGenre((String) any())).thenReturn(this.questions);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/genre/{genre}", genre)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    public void getAllQuestionsByGenreFailureTest() throws Exception {
//        String genre = this.question.getGenre();
//        when(this.questionService.getAllQuestionsByGenre((String) any())).thenThrow(NoQuestionFoundException.class);
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/questions/genre/{genre}", genre)
//                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(this.questions)))
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//
//    private static String asJsonString(final Object obj)
//    {
//        try{
//            return new ObjectMapper().writeValueAsString(obj);
//
//        }catch(Exception e){
//            throw new RuntimeException(e);
//        }
//    }
//}