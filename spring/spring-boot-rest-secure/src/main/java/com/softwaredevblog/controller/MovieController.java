package com.softwaredevblog.controller;

import com.softwaredevblog.entities.Movie;
import com.softwaredevblog.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movie")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> moviesList = new ArrayList<>();
        Iterable<Movie> moviesIterable = movieRepository.findAll();
        moviesIterable.forEach(moviesList::add);

        return new ResponseEntity(moviesList, HttpStatus.OK);
    }

    @PostMapping("/movie")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        // save will either create or update an existing movie if the ID is specified and it exists
        // in the DB
        movieRepository.save(movie);

        return new ResponseEntity(movie, HttpStatus.OK);
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity deleteMovie(@PathVariable("id") Long id) {
        movieRepository.delete(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/movie/search/")
    public ResponseEntity<List<Movie>> getMoviesByDirector(@RequestParam("director") String director) {
        List<Movie> moviesList = new ArrayList<>();
        Iterable<Movie> moviesIterable = movieRepository.findByDirector(director);
        moviesIterable.forEach(moviesList::add);

        return new ResponseEntity(moviesList, HttpStatus.OK);
    }
}
