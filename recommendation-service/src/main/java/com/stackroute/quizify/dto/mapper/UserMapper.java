package com.stackroute.quizify.dto.mapper;

import com.stackroute.quizify.dto.model.UserDTO;
import com.stackroute.quizify.recommendationservice.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);
}
