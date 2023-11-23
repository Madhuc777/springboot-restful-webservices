package com.cg.springbootrestfulwebservices.service.impl;

import com.cg.springbootrestfulwebservices.Entity.User;
import com.cg.springbootrestfulwebservices.repository.UserRepository;
import com.cg.springbootrestfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
