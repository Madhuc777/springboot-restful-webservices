package com.cg.springbootrestfulwebservices.Controller;

import com.cg.springbootrestfulwebservices.Entity.User;
import com.cg.springbootrestfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/users")
public class UserController {

private UserService userService;

//build create user REST API

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser =userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
