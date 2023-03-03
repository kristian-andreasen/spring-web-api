package com.example.moviecharacters.services;

import com.example.moviecharacters.models.Movie;
import com.example.moviecharacters.repositories.CharacterRepository;
import com.example.moviecharacters.repositories.MovieRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final CharacterRepository characterRepository;

    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);

    public MovieServiceImpl(MovieRepository movieRepository, CharacterRepository characterRepository) {
        this.movieRepository = movieRepository;
        this.characterRepository = characterRepository;
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

  /*  public Movie updateCharactersInMovies(Set<Integer> characters, Integer id) {
        Movie movie = movieRepository.findById(id).get();

        characters.forEach(Integer c ->
        movie.setCharacters(characterRepository.findById(c).get());
        );

        movieRepository.save(movie);
    }*/

    @Override
    public Movie update(Movie entity) {
        return movieRepository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (movieRepository.existsById(id)) {
            Movie movie = movieRepository.findById(id).get();
            movie.getCharacters().forEach(s -> s.getMovies().remove(movie));
            movieRepository.delete(movie);
        } else {
            logger.warn("No character exists with ID: " + id);
            movieRepository.deleteById(id);
        }
    }


}
