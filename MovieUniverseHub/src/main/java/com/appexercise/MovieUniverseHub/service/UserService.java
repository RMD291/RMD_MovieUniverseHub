package com.appexercise.MovieUniverseHub.service;

import com.appexercise.MovieUniverseHub.domain.Movie;
import com.appexercise.MovieUniverseHub.domain.MovieList;
import com.appexercise.MovieUniverseHub.domain.MovieStatus;
import com.appexercise.MovieUniverseHub.domain.User;
import com.appexercise.MovieUniverseHub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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

    public void addMovie(User user, Movie movie) {
        if(userRepository.findByUsername(user.getUsername()).isEmpty()) {
            throw new IllegalArgumentException("username does not exist");
        }
        user.getMovies().add(movie);
    }
    public void scoreMovie(User user, Movie movie, int score) {
        if(userRepository.findByUsername(user.getUsername()).isEmpty()) {
            throw new IllegalArgumentException("username does not exist");
        }
        movie.setUserScore(score);
        user.getMovies().add(movie);
    }
    public void changeMovieStatus(User user, Movie movie, MovieStatus status) {
        if(userRepository.findByUsername(user.getUsername()).isEmpty()) {
            throw new IllegalArgumentException("username does not exist");
        }
        movie.setMovieStatus(status);
        user.getMovies().add(movie);
    }
    public void createList(User user, String listName) {
        if(userRepository.findByUsername(user.getUsername()).isEmpty()) {
            throw new IllegalArgumentException("username does not exist");
        }
        user.getMovieLists().add(new MovieList(listName, user));
    }
    public void addMovieToList(User user, Movie movie, MovieList movieList) {
        if(userRepository.findByUsername(user.getUsername()).isEmpty()) {
            throw new IllegalArgumentException("username does not exist");
        }
        movieList.addMovie(movie);
        user.getMovies().add(movie);
    }
}
