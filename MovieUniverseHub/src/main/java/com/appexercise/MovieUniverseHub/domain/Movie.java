package com.appexercise.MovieUniverseHub.domain;

import jakarta.persistence.*;

@Entity
public class MovieList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public MovieList() {}
    public MovieList(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name is required");
        }
        this.name = name;
    }

    /*Getters*/
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    /*Setters*/
    public void setId(int id) {
        this.id = id;
    }
    public void setUsername(String name) {
        this.name = name;
    }
}
