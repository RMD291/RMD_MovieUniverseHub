package com.appexercise.MovieUniverseHub.controller;

import com.appexercise.MovieUniverseHub.domain.Movie;
import com.appexercise.MovieUniverseHub.domain.MovieList;
import com.appexercise.MovieUniverseHub.dto.RegisterRequest;
import com.appexercise.MovieUniverseHub.service.UserService;
import com.appexercise.MovieUniverseHub.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
         this.userService = userService;
     }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        try {
            User user_n = userService.register(registerRequest.getUsername(),
                    registerRequest.getPassword(),
                    registerRequest.getEmail());
            return ResponseEntity.ok(user_n);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            Optional<User> user_n = userService.login(user.getUsername(),user.getPassword());
            return ResponseEntity.ok(user_n);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/newList")
    public ResponseEntity<?> newList(@RequestBody String username, String name) {
        try {
            Optional<User> user_n = userService.findByUsername(username);
            if(user_n.isPresent()) {
                userService.createList(user_n.get(), name);
                return ResponseEntity.ok(user_n);
            }
            else  {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/addMovieToList")
    public ResponseEntity<?> addMovieToList(@RequestBody User user) {
        try {
            User user_n = userService.register(user.getUsername(),user.getPassword(),user.getEmail());
            return ResponseEntity.ok(user_n);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/scoreMovie")
    public ResponseEntity<?> scoreMovie(@RequestBody Movie movie, int score) {
        try {
            movie.setUserScore(score);
            return ResponseEntity.ok(movie);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getMovieLists")
    public ResponseEntity<?> getMovieLists(@RequestBody User user) {
        try {
            Optional<User> user_n = userService.findByUsername(user.getUsername());
            if(user_n.isPresent()) {
                List<MovieList> movies = user_n.get().getMovieLists().stream().toList();
                return ResponseEntity.ok(movies);
            }
            else  {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/getMoviesFromList")
    public ResponseEntity<?> getMoviesFromList(@RequestBody User user) {
        try {
            Optional<User> user_n = userService.findByUsername(user.getUsername());
            if(user_n.isPresent()) {
                List<Movie> movies = user_n.get().getMovies().stream().toList();
                return ResponseEntity.ok(movies);
            }
            else  {
                return ResponseEntity.notFound().build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
