package com.example.moviecharacters.controllers;

import com.example.moviecharacters.dto.MovieCreateDTO;
import com.example.moviecharacters.dto.MovieGetDTO;
import com.example.moviecharacters.dto.MovieUpdateDTO;
import com.example.moviecharacters.mappers.MovieMapper;
import com.example.moviecharacters.models.Movie;
import com.example.moviecharacters.services.MovieServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RequestMapping("/api/v1/movies") //base path
@RestController
public class MovieController {
    private final MovieServiceImpl movieService;
    private final MovieMapper movieMapper;


    public MovieController(MovieServiceImpl movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @GetMapping
    public ResponseEntity<Collection<MovieGetDTO>> getAllMovies() {
        Collection<MovieGetDTO> movieDTOs = movieService.findAll()
                .stream()
                .map(movieMapper::toMovieDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(movieDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieGetDTO> getMovieById(@PathVariable int id) {
        MovieGetDTO movieGetDTO = movieMapper.toMovieDto(movieService.findById(id));
        return ResponseEntity.ok(movieGetDTO);
    }

    @PostMapping
    public ResponseEntity<MovieGetDTO> createMovie(@RequestBody MovieCreateDTO movieCreateDTO) {
        Movie movie = movieMapper.toMovie(movieCreateDTO);
        Movie savedMovie = movieService.add(movie);
        MovieGetDTO movieDTO = movieMapper.toMovieDto(savedMovie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieGetDTO> updateMovie(@PathVariable Integer id, @RequestBody MovieUpdateDTO movieUpdateDTO) {
        Movie movie = movieService.findById(id);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }
        movieMapper.updateMovieFromDto(movieUpdateDTO, movie);
        movieService.update(movie);
        MovieGetDTO movieDTO = movieMapper.toMovieDto(movie);
        return ResponseEntity.ok(movieDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
