package com.appexercise.MovieUniverseHub.controller;

import com.appexercise.MovieUniverseHub.dto.ApiMovieSearchRequestResponse;
import com.appexercise.MovieUniverseHub.service.ApiConnectService;
import com.appexercise.MovieUniverseHub.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;
    private final ApiConnectService apiConnectService;

    @Autowired
    public MovieController(MovieService movieService, ApiConnectService apiConnectService) {
         this.movieService = movieService;
         this.apiConnectService = apiConnectService;
     }

    @PostMapping("/apiSearch")
    public ResponseEntity<?> searchApiMovies(@RequestParam String query) {
        try {
            ApiMovieSearchRequestResponse response = apiConnectService.searchMovies(query);
            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
