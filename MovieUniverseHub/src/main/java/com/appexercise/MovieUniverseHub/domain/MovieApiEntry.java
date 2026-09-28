package com.appexercise.MovieUniverseHub.domain;

import jakarta.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String movieName;
    private int userScore;
    private MovieStatus movieStatus;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Movie() {}
    public Movie(String movieName) {
        if (movieName == null) {
            throw new IllegalArgumentException("Name is required");
        }
        this.movieName = movieName;
    }

    /*Getters*/
    public int getId() {
        return id;
    }
    public String getMovieName() {
        return movieName;
    }
    public int getUserScore() {
        return userScore;
    }
    public MovieStatus getMovieStatus() {
        return movieStatus;
    }

    /*Setters*/
    public void setId(int id) {
        this.id = id;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }
    public void setMovieStatus(MovieStatus movieStatus) {
        this.movieStatus = movieStatus;
    }
}
