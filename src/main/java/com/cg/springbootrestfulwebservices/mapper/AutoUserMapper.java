package com.cg.springbootrestfulwebservices.mapper;

import com.cg.springbootrestfulwebservices.Entity.User;
import com.cg.springbootrestfulwebservices.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    @Mapping(source = "email",target = "email")   //in case if dto and entity classes has different variable names
UserDto mapToUserDto(User user);

User mapToUser (UserDto userDto);

}
