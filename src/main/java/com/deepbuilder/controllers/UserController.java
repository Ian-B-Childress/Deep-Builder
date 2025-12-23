package com.deepbuilder.controllers;

import com.deepbuilder.dto.UserDto;
import com.deepbuilder.entities.User;
import com.deepbuilder.exception.DaoException;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.deepbuilder.repository.UserRepository;
import com.deepbuilder.services.UserService;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {
private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    //saves me the time from the tedious continuous
    @ExceptionHandler(DaoException.class)
    public ResponseEntity<String> handleExceptions(DaoException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @PostMapping()
    public ResponseEntity<User> createNewUser(@RequestBody User user){
        if(user == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
            User savedUser = userService.createUser(user);
            return ResponseEntity.ok(savedUser);
    }


    @GetMapping(path = "/{userId}")
    public ResponseEntity<UserDto> findUser(@PathVariable Long userId){
       if(userId < 0){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
       }
       User user = userService.findById(userId);

        return ResponseEntity.ok(new UserDto(user));
    }
}
