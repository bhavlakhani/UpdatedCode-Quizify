package com.stackroute.quizify.dto.mapper;

import com.stackroute.quizify.dto.model.GameDTO;
import com.stackroute.quizify.searchservice.domain.Game;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GameMapper {
    GameMapper INSTANCE = Mappers.getMapper(GameMapper.class);


    GameDTO gameToGameDTO(Game game);
    Game gameDTOToGame(GameDTO gameDTO);

}
