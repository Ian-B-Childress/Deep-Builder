package com.deepbuilder.controllers;

import com.deepbuilder.entities.User;
import com.deepbuilder.exception.DaoException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.deepbuilder.repository.UserRepository;
import com.deepbuilder.services.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {
UserService userService;


    @PostMapping()
    public ResponseEntity<User> createNewUser(@RequestBody User user){
        if(user == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        try{
            return createNewUser(user);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (Exception e){
            throw new DaoException("Cannot create user.");
        }

    }
}
