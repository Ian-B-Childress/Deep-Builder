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

    /**
     * Finds users based off their id, abstracted in controller to leave out hashes
     *
     * @param userId what account are you trying to find?
     * @return account with this userId
     * @throws DaoException passed when something goes awry with the passed in data, or the finding of data
     */

    public User findById(Long userId){
        try{
            if(userId == null || userId < 0){
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

    public User updateUser(Long userId, User user){
        User foundUser;
        try{
            if(userId < 0 || user == null){
                throw new Exception();
            }
            foundUser = findById(userId);
            foundUser.setUsername(user.getUsername());
            foundUser.setHash(user.getHash());

        } catch (Exception e) {
            throw new DaoException("user ID must be valid, cannot update this user.");
        }
        return userRepository.save(foundUser);
    }

    public List<User> findUserByUsername(String username){
        try{
            if(username == null || username.isBlank()){
                throw new Exception();
            }
            return userRepository.findByUsernameContainingIgnoreCase(username);
        }catch (Exception e){
            throw new DaoException("Could not find this user!");
        }
    }

}
