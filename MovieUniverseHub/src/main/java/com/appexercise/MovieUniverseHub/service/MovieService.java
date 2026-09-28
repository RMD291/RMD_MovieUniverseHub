package com.appexercise.MovieUniverseHub.service;

import com.appexercise.MovieUniverseHub.domain.Movie;
import com.appexercise.MovieUniverseHub.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public Optional<Movie> findByName(String movieName) {
        return movieRepository.findByMovieName(movieName);
    }
}
