package com.stackroute.quizify.dto.mapper;

import com.stackroute.quizify.dto.model.QuestionDTO;
import com.stackroute.quizify.gamemanager.domain.Question;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionMapper {
    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    QuestionDTO questionToQuestionDTO(Question question);
    Question questionDTOtoQuestion(QuestionDTO questionDTO);
}
