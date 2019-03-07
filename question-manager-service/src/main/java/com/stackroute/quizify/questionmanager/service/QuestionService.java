package com.stackroute.quizify.questionmanager.service;

import com.stackroute.quizify.dto.model.QuestionDTO;
import com.stackroute.quizify.questionmanager.exception.EnoughQuestionsNotFound;
import com.stackroute.quizify.questionmanager.exception.NoQuestionFoundException;
import com.stackroute.quizify.questionmanager.exception.QuestionAlreadyExistsException;
import com.stackroute.quizify.questionmanager.exception.QuestionDoesNotExistException;
import com.stackroute.quizify.questionmanager.domain.Question;

import java.util.List;

/*
 * This "QuestionService" Interface is used to declare all the necessary services/methods
 * which are must be implemented by the Implementing Class (QuestionServiceImpl).
 *
 *The Method "addNewQuestion" will add/save a new document of Question in a collection,
 * and will return the Saved/Added Question.
 * If Question ID already exist then it will throw the Exception "CategoryNameAlreadyExistsException".
 *
 *The Method "updateQuestion" will update the Question Document, and will return the Updated Document.
 * If any Question not found with the question ID then it will throw the exception "QuestionDoesNotExistException".
 *
 * The Method "removeQuestion" will delete/remove a specific Question form the collection and will
 * return the Deleted/Removed Question.
 * If the Question doesn't exist then it will throw "QuestionDoesNotExistException".
 *
 * The Method "getQuestion" will fetch specific number of Questions matching a given categoryName, a given topicName
 * and a given level.
 * If no Question found then it will throw the exception "NoQuestionFoundException".
 *
 * The Method "getAllQuestions" will fetch all of the Questions matching a given categoryName and a given topicName.
 * If no Question found then it will throw the exception "NoQuestionFoundException".
 */

public interface QuestionService {
    QuestionDTO addNewQuestion(Question question) throws QuestionAlreadyExistsException;
    Question updateQuestion(Question question) throws QuestionDoesNotExistException;
    Question removeQuestion(long questionId) throws QuestionDoesNotExistException;

    List<Question> getQuestionsByTagByLevel(String tagName, String level, int numberOfQuestions) throws NoQuestionFoundException, EnoughQuestionsNotFound;
    List<Question> getQuestionsByTag(String tagName, int numberOfQuestions) throws NoQuestionFoundException, EnoughQuestionsNotFound;
    List<Question> getAllQuestionsByTag(String tagName)throws NoQuestionFoundException;

    List<Question> getQuestionsByTopicByLevel(String topicName, String level, int numberOfQuestions) throws NoQuestionFoundException, EnoughQuestionsNotFound;
    List<Question> getQuestionsByTopic(String topicName, int numberOfQuestions) throws NoQuestionFoundException, EnoughQuestionsNotFound;
    List<Question> getAllQuestionsByTopic(String topicName)throws NoQuestionFoundException;

    List<Question> getQuestionsByGenreByLevel(String genreName, String level, int numberOfQuestions) throws NoQuestionFoundException, EnoughQuestionsNotFound;
    List<Question> getQuestionsByGenre(String genreName, int numberOfQuestions) throws NoQuestionFoundException, EnoughQuestionsNotFound;
    List<Question> getAllQuestionsByGenre(String genreName)throws NoQuestionFoundException;

    List<Question> getQuestionsByTopicByGenreByLevel(String topicName, String genreName, String level, int numberOfQuestions) throws NoQuestionFoundException, EnoughQuestionsNotFound;
}
