package com.deepbuilder.security;

import com.deepbuilder.entities.Authority;
import com.deepbuilder.entities.User;
import com.deepbuilder.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class UserModelDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserModelDetailsService.class);

    private final UserService userService;

    public UserModelDetailsService(UserService userService) {
        this.userService = userService;

    }

    @Override
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating user '{}'", login);

        String lowercaseLogin = login.toLowerCase();

        User user = userService.getUserByUsername(lowercaseLogin);
        if (user != null) {
            return createSpringSecurityUser(lowercaseLogin, user);
        } else {
            throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found.");
        }
    }

    private org.springframework.security.core.userdetails.User createSpringSecurityUser(String lowercaseLogin, User user) {
        if (!user.isActivated()) {
            throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
        }

        Set<Authority> userAuthorities = user.getAuthorities();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : userAuthorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getHash(),
                grantedAuthorities
        );
    }
}