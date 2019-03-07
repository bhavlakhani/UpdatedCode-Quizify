package com.stackroute.quizify.dto.mapper;

import com.stackroute.quizify.dto.model.GenreDTO;
import com.stackroute.quizify.recommendationservice.domain.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper {

    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);


    GenreDTO genreToGenreDTO(Genre genre);
    Genre genreDTOToGenre(GenreDTO genreDTO);
}
