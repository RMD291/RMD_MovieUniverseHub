package com.appexercise.MovieUniverseHub.service;

import com.appexercise.MovieUniverseHub.domain.User;
import com.appexercise.MovieUniverseHub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /* register - Registers a new user, if username is free */
    public User register(String username, String email, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("username already exists");
        }

        User user = new User(username, email, password);
        return userRepository.save(user);
    }

    /* login - Logins a user, if user exists and password matches */
    public Optional<User> login(String email, String password) {
        Optional<User> user = userRepository.findByUsername(email);
        if (user.isPresent()) {
            if (user.get().getPassword().equals(password)) {
                return user;
            }
        }
        return Optional.empty();
    }
}
