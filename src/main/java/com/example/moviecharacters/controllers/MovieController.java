package com.example.moviecharacters.controllers;

import com.example.moviecharacters.dto.character.FranchiseGetDTO;
import com.example.moviecharacters.dto.character.MovieGetDTO;
import com.example.moviecharacters.mappers.MovieMapper;
import com.example.moviecharacters.services.MovieServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/movies") //base path
@RestController
public class MovieController {
    private final MovieServiceImpl movieService;
    private final MovieMapper movieMapper;


    public MovieController(MovieServiceImpl movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieGetDTO> getMovieById(@PathVariable int id) {
        MovieGetDTO movieGetDTO = movieMapper.toMovieDto(movieService.findById(id));
        return ResponseEntity.ok(movieGetDTO);
    }
}
