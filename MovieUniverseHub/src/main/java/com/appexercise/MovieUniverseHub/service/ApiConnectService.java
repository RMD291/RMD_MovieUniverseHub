package com.appexercise.MovieUniverseHub.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.appexercise.MovieUniverseHub.dto.ApiMovieSearchRequestResponse;
import com.appexercise.MovieUniverseHub.dto.TmdbMovie;

@Service
public class ApiConnectService {

    private final RestClient tmdbRestClient;

    public ApiConnectService(RestClient tmdbRestClient) {
        this.tmdbRestClient = tmdbRestClient;
    }

    public void searchMovie() {
    }

    public ApiMovieSearchRequestResponse searchMovies(String query) {

        return tmdbRestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/movie")
                        .queryParam("query", query)
                        .queryParam("language", "en-US")
                        .build())
                .retrieve()
                .body(ApiMovieSearchRequestResponse.class);
    }
}
