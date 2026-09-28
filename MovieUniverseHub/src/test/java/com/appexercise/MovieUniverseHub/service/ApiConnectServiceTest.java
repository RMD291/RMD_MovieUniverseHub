package com.appexercise.MovieUniverseHub.service;

import com.appexercise.MovieUniverseHub.dto.ApiMovieSearchRequestResponse;
import com.appexercise.MovieUniverseHub.dto.TmdbMovie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApiConnectServiceTest {
    @Autowired
    private ApiConnectService apiConnectService;

    @Test
    public void searchMoviesTest(){
        ApiMovieSearchRequestResponse response = apiConnectService.searchMovies("man");

        System.out.println("Page: " + response.getPage());
        System.out.println("Pages: " + response.getTotal_pages());
        System.out.println("Number of Results: " + response.getTotal_results());

        //for (TmdbMovie tmdbMovie : response.getResults()) {
        //    System.out.println("/*--- Movie ---*/");
        //    System.out.println("Movie Title: " + tmdbMovie.getTitle());
        //    System.out.println("Release date: " + tmdbMovie.getRelease_date());
        //    System.out.println("Average vote: " + tmdbMovie.getVote_average());
        //    System.out.println("Vote count: " + tmdbMovie.getVote_count());
        //    System.out.println("Overview: " + tmdbMovie.getOverview());
        //}

        TmdbMovie tmdbMovie = response.getResults().get(0);
        System.out.println("/*--- Movie 1 ---*/");
        System.out.println("Movie Title: " + tmdbMovie.getTitle());
        System.out.println("Release date: " + tmdbMovie.getRelease_date());
        System.out.println("Average vote: " + tmdbMovie.getVote_average());
        System.out.println("Vote count: " + tmdbMovie.getVote_count());
        System.out.println("Overview: " + tmdbMovie.getOverview());
        tmdbMovie = response.getResults().get(1);
        System.out.println("/*--- Movie 2 ---*/");
        System.out.println("Movie Title: " + tmdbMovie.getTitle());
        System.out.println("Release date: " + tmdbMovie.getRelease_date());
        System.out.println("Average vote: " + tmdbMovie.getVote_average());
        System.out.println("Vote count: " + tmdbMovie.getVote_count());
        System.out.println("Overview: " + tmdbMovie.getOverview());

    }
}
