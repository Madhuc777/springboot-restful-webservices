package com.cg.springbootrestfulwebservices.mapper;

import com.cg.springbootrestfulwebservices.Entity.User;
import com.cg.springbootrestfulwebservices.dto.UserDto;

public class UserMapper {

    public  static UserDto mapToUserDto (User user){
//Convert User Jpa Entity into UserDto
        UserDto userDto=new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }
    //Convert UserDto  Entity into User Jpa

    public  static  User mapToUser(UserDto userDto){

        User user=new User(userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }

}
