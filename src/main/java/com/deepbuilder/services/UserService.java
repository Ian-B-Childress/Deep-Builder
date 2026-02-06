package com.deepbuilder.services;

import com.deepbuilder.entities.Role;
import com.deepbuilder.entities.User;
import com.deepbuilder.exception.DaoException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.deepbuilder.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private Role role;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

   public User createUser(@Valid User user){
        try{
            if(user.getUsername().isBlank() || user.getPassword().isBlank()){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
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
            foundUser.setPassword(user.getPassword());

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

    public User getUserByUsername(String username) {
        try{
            if(username.isBlank()){
                throw new Exception();
            }
            return userRepository.findByUsername(username);
        }catch (Exception e){
            throw new DaoException("Could not get by username.");
        }
    }
}
