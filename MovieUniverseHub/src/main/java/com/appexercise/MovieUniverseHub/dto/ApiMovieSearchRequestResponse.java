package com.appexercise.MovieUniverseHub.dto;

import java.util.List;

public class ApiMovieSearchRequestResponse {
    private List<TmdbMovie> results;
    private int page;
    private int total_pages;
    private int total_results;

    /* Getters */

    public List<TmdbMovie> getResults() {
        return results;
    }
    public int getPage() {
        return page;
    }
    public int getTotal_pages() {
        return total_pages;
    }
    public int getTotal_results() {
        return total_results;
    }

    /* Setters */
    public void setResults(List<TmdbMovie> results) {
        this.results = results;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }
}
