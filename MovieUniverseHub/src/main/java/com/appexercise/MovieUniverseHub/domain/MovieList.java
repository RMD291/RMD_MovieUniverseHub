package com.appexercise.MovieUniverseHub.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class MovieList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany
    private Set<Movie> movies;

    public MovieList() {}
    public MovieList(String name, User user) {
        if (name == null || user == null) {
            throw new IllegalArgumentException("Name and user are required");
        }
        this.name = name;
        this.user = user;
    }

    /*Getters*/
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public User getUser() {
        return user;
    }
    public Set<Movie> getMovies() {
        return movies;
    }

    /*Setters*/
    public void setId(int id) {
        this.id = id;
    }
    public void setUsername(String name) {
        this.name = name;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }
}
