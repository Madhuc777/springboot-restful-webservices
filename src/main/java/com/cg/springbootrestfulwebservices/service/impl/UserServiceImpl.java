package com.cg.springbootrestfulwebservices.service.impl;

import com.cg.springbootrestfulwebservices.Entity.User;
import com.cg.springbootrestfulwebservices.dto.UserDto;
import com.cg.springbootrestfulwebservices.exception.EmailAlreadyExistsException;
import com.cg.springbootrestfulwebservices.exception.ResourceNotFoundException;
import com.cg.springbootrestfulwebservices.mapper.AutoUserMapper;
import com.cg.springbootrestfulwebservices.mapper.UserMapper;
import com.cg.springbootrestfulwebservices.repository.UserRepository;
import com.cg.springbootrestfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        //convert userDto into userJpa entity
        //User user = UserMapper.mapToUser(userDto);
//        User user = modelMapper.map(userDto,User.class);
        Optional<User> optionalUser=userRepository.findByEmail(userDto.getEmail());
 if(optionalUser.isPresent())
 {
     throw new EmailAlreadyExistsException("Email already exists for a user");

 }



        User user = AutoUserMapper.MAPPER.mapToUser(userDto);
        User savedUser = userRepository.save(user);

        //convert userJpa entity into userDto
//        UserDto savedUserDto = UserMapper.mapToUserDto(user);
//        UserDto savedUserDto = modelMapper.map(savedUser,UserDto.class);
        UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(user);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                ()->
                    new ResourceNotFoundException("User","id", userId)

        );

//      //  return  UserMapper.mapToUserDto(user);
        return  AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User> users= userRepository.findAll();
//       return users.stream().map(UserMapper::mapToUserDto)
//               .collect(Collectors.toList());

        return users.stream().map((user)->AutoUserMapper.MAPPER.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(
                ()->
                     new   ResourceNotFoundException("User","id",user.getId())

        );
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
//        return UserMapper.mapToUserDto(updatedUser);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);

    }

    @Override
    public void deleteUser(Long userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(
                ()->
                        new   ResourceNotFoundException("User","id",userId)

        );
        userRepository.deleteById(userId);


    }
}