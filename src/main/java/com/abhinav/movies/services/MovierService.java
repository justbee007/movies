package com.abhinav.movies.services;

import com.abhinav.movies.pojo.Movie;
import com.abhinav.movies.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovierService {
    @Autowired
    private MovieRepository movieRepository;
public List<Movie> allMovies()
{
    return movieRepository.findAll();


}
public Optional<Movie> singleMovie(String imdbid)
{
   return movieRepository.findMovieByImdbId(imdbid);

}
}
