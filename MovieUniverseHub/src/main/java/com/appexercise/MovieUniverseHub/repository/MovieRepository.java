package com.appexercise.MovieUniverseHub.repository;

import com.appexercise.MovieUniverseHub.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Optional<Movie> findByMovieName(String movieName);
}
