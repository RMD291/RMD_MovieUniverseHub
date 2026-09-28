package com.appexercise.MovieUniverseHub.domain;

import jakarta.persistence.*;

@Entity
public class MovieApiEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Long apiId;
    private String title;
    private String poster_path;

    public MovieApiEntry() {}
    public MovieApiEntry(Long apiId,
                         String title,
                         String poster_path) {
        this.apiId = apiId;
        this.title = title;
        this.poster_path = poster_path;
    }

    /*Getters*/
    public int getId() {
        return id;
    }
    public Long getApiId() {
        return apiId;
    }
    public String getTitle() {
        return title;
    }
    public String getPoster_path() {
        return poster_path;
    }

    /*Setters*/
    public void setId(int id) {
        this.id = id;
    }
    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
