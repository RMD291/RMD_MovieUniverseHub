package com.appexercise.MovieUniverseHub.domain;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    private String username;
    private String password;
    @Column(unique=true)
    private String email;

    public User() {}
    public User(String username, String password, String email) {
        if (username == null || password == null || email == null) {
            throw new IllegalArgumentException("Username, email and/or password are required");
        }
        this.username = username;
        this.password = password;
        this.email = email;
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
}
