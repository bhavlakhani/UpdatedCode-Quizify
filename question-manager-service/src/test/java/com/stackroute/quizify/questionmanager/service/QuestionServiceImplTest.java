//package com.stackroute.quizify.questionmanager.service;
//
//import com.stackroute.quizify.kafka.Producer;
//import com.stackroute.quizify.questionmanager.exception.NoQuestionFoundException;
//import com.stackroute.quizify.questionmanager.exception.QuestionAlreadyExistsException;
//import com.stackroute.quizify.questionmanager.exception.QuestionDoesNotExistException;
//import com.stackroute.quizify.questionmanager.repository.QuestionRepository;
//import com.stackroute.quizify.kafka.domain.Admin;
//import Category;
//import Question;
//import Topic;
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
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//public class QuestionServiceImplTest {
//
//    private Admin admin;
//    private Category category;
//    private Topic topicMovies;
//    private Topic topicTvShows;
//    private Question question;
//    private List<Question> questions;
//
//    @Mock
//    private QuestionRepository questionRepository;
//
//    @Mock
//    private Producer producer;
//
//    @InjectMocks
//    private QuestionServiceImpl questionService;
//
//    /*
//     * Setting Up Values for all required objects and lists
//     * Objects will be Initialized before each Test
//     */
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
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
////    ------------------------------------------Test Cases for CRUD Services
//    @Test
//    public void addNewQuestionSuccessTest() throws QuestionAlreadyExistsException {
//        when(this.questionRepository.existsById(anyLong())).thenReturn(false);
//        when(this.producer.send((Question) any())).thenReturn(this.question);
//        when(this.questionRepository.save((Question)any())).thenReturn(this.question);
//
//        Question savedQuestion = this.questionService.addNewQuestion(this.question);
//        assertEquals(this.question, savedQuestion);
//
//        verify(this.questionRepository, times(1)).existsById(anyLong());
//        verify(this.producer, times(1)).send((Question) any());
//        verify(this.questionRepository, times(1)).save((Question)any());
//    }
//
//    @Test(expected = QuestionAlreadyExistsException.class)
//    public void addNewQuestionFailureTest() throws QuestionAlreadyExistsException {
//        when(this.questionRepository.existsById(anyLong())).thenReturn(true);
//
//        Question savedQuestion = this.questionService.addNewQuestion(this.question);
//
//        verify(this.questionRepository, times(1)).existsById(anyLong());
//
//    }
//
//    @Test
//    public void updateQuestionSuccessTest() throws QuestionDoesNotExistException {
//        when(this.questionRepository.existsById(anyLong())).thenReturn(true);
//        when(this.producer.send((Question) any())).thenReturn(this.question);
//        when(this.questionRepository.save((Question)any())).thenReturn(this.question);
//
//        Question updatedQuestion = this.questionService.updateQuestion(this.question);
//        assertEquals(this.question, updatedQuestion);
//
//        verify(this.questionRepository, times(1)).existsById(anyLong());
//        verify(this.producer, times(1)).send((Question) any());
//        verify(this.questionRepository, times(1)).save((Question)any());
//    }
//
//    @Test(expected = QuestionDoesNotExistException.class)
//    public void updateQuestionFailureTest() throws QuestionDoesNotExistException {
//        when(this.questionRepository.existsById(anyLong())).thenReturn(false);
//
//        Question savedQuestion = this.questionService.updateQuestion(this.question);
//
//        verify(this.questionRepository, times(1)).existsById(anyLong());
//    }
//
//    @Test
//    public void removeQuestionSuccessTest() throws QuestionDoesNotExistException {
//        when(this.questionRepository.existsById(anyLong())).thenReturn(true);
//
//        Question updatedQuestion = this.questionService.removeQuestion(this.question);
//        assertEquals(this.question, updatedQuestion);
//
//        verify(this.questionRepository, times(1)).existsById(anyLong());
//        verify(this.questionRepository, times(1)).delete((Question)any());
//    }
//
//    @Test(expected = QuestionDoesNotExistException.class)
//    public void removeQuestionFailureTest() throws QuestionDoesNotExistException {
//        when(this.questionRepository.existsById(anyLong())).thenReturn(false);
//
//        this.questionService.removeQuestion(this.question);
//
//        verify(this.questionRepository, times(1)).existsById(anyLong());
//    }
//
////    ---------------------------------------------------Test Cases for Getting Questions by Tag
//
//    @Test
//    public void getQuestionsByTagByLevelSuccessTest()throws NoQuestionFoundException
//    {
//        String tag = this.question.getTag();
//        String level = this.question.getLevel();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByTagByLevel((String)any(), (String)any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByTagByLevel(tag, level, 1);
//
//        assertTrue(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTagByLevel((String)any(), (String)any());
//
//    }
//
//    @Test(expected = NoQuestionFoundException.class)
//    public void getQuestionsByTagByLevelFailureTest()throws NoQuestionFoundException
//    {
//        String tag = this.question.getTag();
//        String level = this.question.getLevel();
//
//        when(this.questionRepository.getQuestionsByTagByLevel((String)any(), (String)any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByTagByLevel(tag, level, 1);
//
//        assertFalse(questionList.contains(this.question));
//        verify(this.questionRepository, times(1)).getQuestionsByTagByLevel((String)any(), (String)any());
//    }
//
//
//    @Test
//    public void getQuestionsByTagSuccessTest()throws NoQuestionFoundException
//    {
//        String tag = this.question.getTag();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByTag((String)any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByTag(tag, 1);
//
//        assertTrue(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTag((String)any());
//
//    }
//
//    @Test(expected = NoQuestionFoundException.class)
//    public void getQuestionsByTagFailureTest()throws NoQuestionFoundException
//    {
//        String tag = this.question.getTag();
//
//        when(this.questionRepository.getQuestionsByTag((String)any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByTag(tag, 1);
//
//        assertFalse(questionList.contains(this.question));
//        verify(this.questionRepository, times(1)).getQuestionsByTag((String)any());
//    }
//
//    @Test
//    public void getAllQuestionsByTagSuccessTest()throws NoQuestionFoundException
//    {
//        String tag = this.question.getTag();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByTag((String)any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getAllQuestionsByTag(tag);
//
//        assertTrue(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTag((String)any());
//
//    }
//
//    @Test(expected = NoQuestionFoundException.class)
//    public void getAllQuestionsByTagFailureTest()throws NoQuestionFoundException
//    {
//        String tag = this.question.getTag();
//
//        when(this.questionRepository.getQuestionsByTag((String)any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getAllQuestionsByTag(tag);
//
//        assertFalse(questionList.contains(this.question));
//        verify(this.questionRepository, times(1)).getQuestionsByTag((String)any());
//    }
//
////    -----------------------------------------------------------Test Cases for getting Questions by Topic
//
//    @Test
//    public void getQuestionsByTopicByLevelSuccessTest()throws NoQuestionFoundException
//    {
//        Topic topic = this.question.getTopic();
//        String level = this.question.getLevel();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByTopicByLevel((String)any(), (String)any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByTopicByLevel(topic.getName(), level, 1);
//
//        assertTrue(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTopicByLevel((String)any(), (String)any());
//
//    }
//
//    @Test(expected = NoQuestionFoundException.class)
//    public void getQuestionsByTopicByLevelFailureTest()throws NoQuestionFoundException
//    {
//        Topic topic = this.question.getTopic();
//        String level = this.question.getLevel();
//
//        when(this.questionRepository.getQuestionsByTopicByLevel((String)any(), (String)any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByTopicByLevel(topic.getName(), level, 1);
//
//        assertFalse(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTopicByLevel((String)any(), (String)any());
//    }
//
//
//    @Test
//    public void getQuestionsByTopicSuccessTest()throws NoQuestionFoundException
//    {
//        Topic topic = this.question.getTopic();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByTopic((String)any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByTopic(topic.getName(), 1);
//
//        assertTrue(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTopic((String)any());
//
//    }
//
//    @Test(expected = NoQuestionFoundException.class)
//    public void getQuestionsByTopicFailureTest()throws NoQuestionFoundException
//    {
//        Topic topic = this.question.getTopic();
//
//        when(this.questionRepository.getQuestionsByTopic((String)any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByTopic(topic.getName(), 1);
//
//        assertFalse(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTopic((String)any());
//    }
//
//    @Test
//    public void getAllQuestionsByTopicSuccessTest()throws NoQuestionFoundException
//    {
//        Topic topic = this.question.getTopic();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByTopic((String)any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getAllQuestionsByTopic(topic.getName());
//
//        assertTrue(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTopic((String)any());
//
//    }
//
//    @Test(expected = NoQuestionFoundException.class)
//    public void getAllQuestionsByTopicFailureTest()throws NoQuestionFoundException
//    {
//        Topic topic = this.question.getTopic();
//
//        when(this.questionRepository.getQuestionsByTopic((String)any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getAllQuestionsByTopic(topic.getName());
//
//        assertFalse(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByTopic((String)any());
//    }
//
////    -------------------------------------------------------Test cases for getting questions by Genre
//
//    @Test
//    public void getQuestionsByGenreByLevelSuccessTest()throws NoQuestionFoundException
//    {
//        String genre = this.question.getGenre();
//        String level = this.question.getLevel();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByGenreByLevel((String)any(), (String)any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByGenreByLevel(genre, level, 1);
//
//        assertTrue(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByGenreByLevel((String)any(), (String)any());
//
//    }
//
//    @Test(expected = NoQuestionFoundException.class)
//    public void getQuestionsByGenreByLevelFailureTest()throws NoQuestionFoundException
//    {
//        String genre = this.question.getGenre();
//        String level = this.question.getLevel();
//
//        when(this.questionRepository.getQuestionsByGenreByLevel((String)any(), (String)any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByGenreByLevel(genre, level, 1);
//
//        assertFalse(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByGenreByLevel((String)any(), (String)any());
//    }
//
//
//    @Test
//    public void getQuestionsByGenreSuccessTest()throws NoQuestionFoundException
//    {
//        String genre = this.question.getGenre();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByGenre((String)any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByGenre(genre, 1);
//
//        assertTrue(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByGenre((String)any());
//
//    }
//
//    @Test(expected = NoQuestionFoundException.class)
//    public void getQuestionsByGenreFailureTest()throws NoQuestionFoundException
//    {
//        String genre = this.question.getGenre();
//
//        when(this.questionRepository.getQuestionsByGenre((String)any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getQuestionsByGenre(genre, 1);
//
//        assertFalse(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByGenre((String)any());
//    }
//
//    @Test
//    public void getAllQuestionsByGenreSuccessTest()throws NoQuestionFoundException
//    {
//        String genre = this.question.getGenre();
//
//        this.questions.add(this.question);
//        when(this.questionRepository.getQuestionsByGenre((String)any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getAllQuestionsByGenre(genre);
//
//        assertTrue(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByGenre((String)any());
//
//    }
//
//    @Test(expected = NoQuestionFoundException.class)
//    public void getAllQuestionsByGenreFailureTest()throws NoQuestionFoundException
//    {
//        String genre = this.question.getGenre();
//
//        when(this.questionRepository.getQuestionsByGenre((String)any())).thenReturn(this.questions);
//        List<Question> questionList = this.questionService.getAllQuestionsByGenre(genre);
//
//        assertFalse(questionList.contains(this.question));
//
//        verify(this.questionRepository, times(1)).getQuestionsByGenre((String)any());
//    }
//
//}