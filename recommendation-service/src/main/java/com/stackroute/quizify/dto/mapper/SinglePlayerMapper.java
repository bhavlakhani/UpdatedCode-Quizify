package com.stackroute.quizify.dto.mapper;


import com.stackroute.quizify.dto.model.SinglePlayerDTO;
import com.stackroute.quizify.recommendationservice.domain.SinglePlayer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SinglePlayerMapper {
    SinglePlayerMapper INSTANCE= Mappers.getMapper(SinglePlayerMapper.class);

    SinglePlayerDTO singlePlayerToSinglePlayerDTO(SinglePlayer singlePlayer);
    SinglePlayer singlePlayerDTOToSinglePlayer(SinglePlayerDTO singlePlayerDTO);

}
