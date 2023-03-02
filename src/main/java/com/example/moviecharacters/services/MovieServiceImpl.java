package com.example.moviecharacters.services;

import com.example.moviecharacters.models.Character;
import com.example.moviecharacters.models.Movie;
import com.example.moviecharacters.repositories.MovieRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie findById(Integer id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie add(Movie entity) {
        return movieRepository.save(entity);
    }

    @Override
    public Movie update(Movie entity) {
        return movieRepository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (movieRepository.existsById(id)) {
            Movie movie = movieRepository.findById(id).get();
            movie.getCharacterSet().forEach(s -> s.getMovieSet().remove(movie));
            movieRepository.delete(movie);
        } else {
            logger.warn("No character exists with ID: " + id);
            movieRepository.deleteById(id);
        }
    }


}
