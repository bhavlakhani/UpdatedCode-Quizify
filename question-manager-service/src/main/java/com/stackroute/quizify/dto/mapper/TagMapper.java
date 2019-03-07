package com.stackroute.quizify.dto.mapper;

import com.stackroute.quizify.dto.model.TagDTO;
import com.stackroute.quizify.questionmanager.domain.Tag;
import org.mapstruct.factory.Mappers;

public interface TagMapper {
    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);


    TagDTO tagToTagDTO(Tag tag);
    Tag tagDTOToTag(TagDTO tagDTO);
}
