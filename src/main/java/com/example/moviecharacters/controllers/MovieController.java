package com.example.moviecharacters.controllers;

import com.example.moviecharacters.dto.MovieCreateDTO;
import com.example.moviecharacters.dto.MovieGetDTO;
import com.example.moviecharacters.dto.MovieUpdateDTO;
import com.example.moviecharacters.mappers.MovieMapper;
import com.example.moviecharacters.models.Character;
import com.example.moviecharacters.models.Movie;
import com.example.moviecharacters.services.CharacterServiceImpl;
import com.example.moviecharacters.services.MovieServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RequestMapping("/api/v1/movies") //base path
@RestController
public class MovieController {
    private final MovieServiceImpl movieService;
    private final CharacterServiceImpl characterService;
    private final MovieMapper movieMapper;

    public MovieController(MovieServiceImpl movieService, CharacterServiceImpl characterService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.characterService = characterService;
        this.movieMapper = movieMapper;
    }
    @Operation(summary = "Gets all of the characters")
    @GetMapping
    public ResponseEntity<Collection<MovieGetDTO>> getAllMovies() {
        Collection<MovieGetDTO> movieDTOs = movieService.findAll()
                .stream()
                .map(movieMapper::toMovieDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(movieDTOs);
    }

    @Operation(summary = "Gets all of the movies")
    @GetMapping("/{id}")
    public ResponseEntity<MovieGetDTO> getMovieById(@PathVariable int id) {
        MovieGetDTO movieGetDTO = movieMapper.toMovieDto(movieService.findById(id));
        return ResponseEntity.ok(movieGetDTO);
    }

    @Operation(summary = "Create a movie and post it")
    @PostMapping
    public ResponseEntity<MovieGetDTO> createMovie(@RequestBody MovieCreateDTO movieCreateDTO) {
        Movie movie = movieMapper.toMovie(movieCreateDTO);
        Movie savedMovie = movieService.add(movie);
        MovieGetDTO movieDTO = movieMapper.toMovieDto(savedMovie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieDTO);
    }

    @Operation(summary = "Updates a movie by a given id")
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

    @Operation(summary = "Updates the characters in a movie")
    @PutMapping("/updateCharactersWhereId={id}")
    public ResponseEntity<MovieGetDTO> updateCharactersInMovie(@PathVariable Integer id, @RequestBody Set<Integer> characterIds) {

       Movie movie = movieService.findById(id);
       List<Integer> characterIdList = new ArrayList<>(characterIds);
       Set<Character> characters = new HashSet<>();

       for(int i = 0; i < characterIds.size(); i++){
           characters.add(characterService.findById(characterIdList.get(i)));
       }
        movie.setCharacters(characters);
        movieService.update(movie);
        MovieGetDTO movieDTO = movieMapper.toMovieDto(movie);
        return ResponseEntity.ok(movieDTO);
    }
    @Operation(summary = "Deletes a given character by its id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Integer id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
