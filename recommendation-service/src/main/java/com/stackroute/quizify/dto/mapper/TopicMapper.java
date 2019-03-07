package com.stackroute.quizify.dto.mapper;

import com.stackroute.quizify.dto.model.TopicDTO;
import com.stackroute.quizify.recommendationservice.domain.Topic;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TopicMapper {

    TopicMapper INSTANCE = Mappers.getMapper(TopicMapper.class);


    TopicDTO topicToTopicDTO(Topic topic);
    Topic topicDTOToTopic(TopicDTO topicDTO);
}
