package com.appexercise.MovieUniverseHub.repository;

import com.appexercise.MovieUniverseHub.domain.MovieList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieListRepository extends JpaRepository<MovieList, Integer> {
    Optional<MovieList> findByName(String name);
}
