package com.appexercise.MovieUniverseHub.dto;

public class TmdbMovie {
    private Long id;
    private String title;
    private String overview;
    private String release_date;
    private String poster_path;
    private Double vote_average;
    private Long vote_count;

    /* Getters */
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getOverview() {
        return overview;
    }
    public String getRelease_date() {
        return release_date;
    }
    public String getPoster_path() {
        return poster_path;
    }
    public Double getVote_average() {
        return vote_average;
    }
    public Long getVote_count() {
        return vote_count;
    }

    /* Setters */
    public void setId(Long id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }
    public void setVote_count(Long vote_count) {
        this.vote_count = vote_count;
    }
}
