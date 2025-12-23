package com.deepbuilder.services;

import com.deepbuilder.entities.User;
import com.deepbuilder.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deepbuilder.repository.UserRepository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   public User createUser(User user){
        try{
            if(user.getUsername().isBlank() || user.getHash().isBlank()){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        return userRepository.save(user);
    }

    public User findById(Long userId){
        try{
            if(userId == null){
                throw new Exception();
            }
            Optional<User> possibleUser = userRepository.findById(userId);
            if(possibleUser.isEmpty()){
                throw new Exception();
            } else {return possibleUser.get();}

        }catch (Exception e){
        throw new DaoException("Sorry, looks like that user doesn't exist! (find by id)");
        }
    }
}
