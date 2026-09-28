package com.appexercise.MovieUniverseHub.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    private String username;
    private String password;
    @Column(unique=true)
    private String email;

    @OneToMany
    private Set<Movie> movies;
    @OneToMany
    private Set<MovieList> movieLists;

    public User() {}
    public User(String username, String password, String email) {
        if (username == null || password == null || email == null) {
            throw new IllegalArgumentException("Username, email and password are required");
        }
        this.username = username;
        this.password = password;
        this.email = email;
        this.movies = new HashSet<Movie>();
        this.movieLists = new HashSet<MovieList>();
    }

    /*Getters*/
    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public Set<Movie> getMovies() {
        return movies;
    }
    public Set<MovieList> getMovieLists() {
        return movieLists;
    }

    /*Setters*/
    public void setId(int id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
    public void setMovieLists(Set<MovieList> movieLists) {
        this.movieLists = movieLists;
    }
}
