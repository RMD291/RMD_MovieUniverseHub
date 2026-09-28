package com.appexercise.MovieUniverseHub.service;

import com.appexercise.MovieUniverseHub.domain.MovieList;
import com.appexercise.MovieUniverseHub.domain.User;
import com.appexercise.MovieUniverseHub.repository.MovieListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieListService {
    private final MovieListRepository movieListRepository;

    @Autowired
    public MovieListService(MovieListRepository movieListRepository) {
        this.movieListRepository = movieListRepository;
    }
    public Optional<MovieList> findByName(String name) {
        return movieListRepository.findByName(name);
    }

    /* createNewList - Creates a new list */
    public MovieList createNewList(String name, User user) {
        MovieList movieList = new MovieList(name, user);
        return movieListRepository.save(movieList);
    }
}
