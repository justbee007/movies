package com.abhinav.movies.controllers;

import com.abhinav.movies.pojo.Movie;
import com.abhinav.movies.repository.MovieRepository;
import com.abhinav.movies.services.MovierService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.StringOperators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {
    @Autowired
    private MovierService movierService;
    @GetMapping
    public ResponseEntity getallmovies()
    {
        return new ResponseEntity<List<Movie>>(movierService.allMovies(), HttpStatus.OK);
    }
    @GetMapping("/{imdbid}")
    public ResponseEntity getMovie(@PathVariable String imdbid)
    {
        return new ResponseEntity<Optional<Movie>>(movierService.singleMovie(imdbid),HttpStatus.OK);
    }
}
