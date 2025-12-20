package services;

import entities.User;

public class UserService {

    User createUser(String username, String password){
        try{
            if(username == null ^ password == null){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

    }
}
