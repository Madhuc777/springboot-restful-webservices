package com.cg.springbootrestfulwebservices.Controller;

import com.cg.springbootrestfulwebservices.Entity.User;
import com.cg.springbootrestfulwebservices.dto.UserDto;
import com.cg.springbootrestfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/users")
public class UserController {

private UserService userService;

//build create user REST API

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        UserDto savedUser =userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //build getuserbyId Rest Api
@GetMapping("{id}")
    public  ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){

       UserDto user= userService.getUserById(userId);

       return new ResponseEntity<>(user,HttpStatus.OK);

}
//build getall users rest Api
@GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users=userService.getAllUsers();

        return new ResponseEntity<>(users, HttpStatus.OK);

    }
    //build update user Rest API
@PutMapping("{id}")
    public  ResponseEntity<UserDto> updateUser( @PathVariable("id") Long userId, @RequestBody UserDto user){
user.setId(userId);
       UserDto updatedUser= userService.updateUser(user);
return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){

        userService.deleteUser(userId);

        return  new ResponseEntity<>("User Successfully Deleted",HttpStatus.OK);
    }
}
