package com.deepbuilder.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "\"users\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_name")
    private String username;
    private String hash;
    @Column(name = "role")
    private String role;
    @JsonIgnore
    private boolean activated;

    public User(){}

    public User(Long userId, String username, String hash, String role) {
        this.userId = userId;
        this.username = username;
        this.hash = hash;
        this.role = role;
        this.activated = true;
    }


    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getHash() { return hash; }
    public void setHash(String hash) { this.hash = hash; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public boolean isActivated() { return activated; }
    public void setActivated(boolean activated) { this.activated = activated; }

    public Set<Authority> getAuthorities() {
        Set<Authority> authorities = new HashSet<>();
        if (role != null && !role.isEmpty()) {
            String authority = role.startsWith("ROLE_") ? role : "ROLE_" + role;
            authorities.add(new Authority(authority));
        }
        return authorities;
    }
}
