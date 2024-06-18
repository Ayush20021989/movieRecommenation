package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie createMovie(@Valid Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie getMovieById(long id) throws ResourceNotFoundException {
        return movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
    }

    public Movie updateMovie(long id, @Valid Movie movie) throws ResourceNotFoundException {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));

        // Update the existing movie with data from the provided movie
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setDirector(movie.getDirector());
        existingMovie.setYear(movie.getYear());
        existingMovie.setGenre(movie.getGenre());

        return movieRepository.save(existingMovie);
    }

    public void deleteMovie(long id) throws ResourceNotFoundException {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));

        movieRepository.delete(movie);
    }
}
