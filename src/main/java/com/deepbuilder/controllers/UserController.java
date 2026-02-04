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
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/users")
public class UserController {
private final UserService userService;
private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
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
        if(userRepository.existsByUsername(user.getUsername())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username is taken");
        }
            User savedUser = userService.createUser(user);
            return ResponseEntity.ok(savedUser);
    }


    @GetMapping(path = "/{userId}")
    public ResponseEntity<UserDto> findUser(@PathVariable Long userId){
       User user = userService.findById(userId);
        return ResponseEntity.ok(new UserDto(user));
    }

    @PutMapping(path = "/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user){
        userService.updateUser(userId, user);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserDto>> findByUser(@RequestParam String username){
       List<User> matchingUsers = userService.findUserByUsername(username);
       List<UserDto> dtoUsers = matchingUsers.stream()
               .map(UserDto::from)
               .toList();

        return ResponseEntity.ok(dtoUsers);
    }
}
