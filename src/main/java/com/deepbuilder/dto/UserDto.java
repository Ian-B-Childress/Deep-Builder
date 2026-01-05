package com.deepbuilder.dto;

import com.deepbuilder.entities.User;
import org.springframework.beans.factory.annotation.Autowired;


public class UserDto {
    private Long id;
    private String username;

    public UserDto(User user) {
        this.id = user.getUserId();
        this.username = user.getUsername();
    }

    public static UserDto from(User user){
        return new UserDto(user);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
