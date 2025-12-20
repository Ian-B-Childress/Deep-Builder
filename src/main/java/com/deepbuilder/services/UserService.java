package com.deepbuilder.services;

import com.deepbuilder.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deepbuilder.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    User createUser(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setHash(password);
        try{
            if(user.getUsername().isBlank() ^ user.getHash().isBlank()){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        return userRepository.save(user);
    }
}
