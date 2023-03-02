package com.example.moviecharacters.mappers;
import com.example.moviecharacters.dto.character.MovieGetDTO;
import com.example.moviecharacters.models.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieGetDTO toMovieDto(Movie movie);
    Movie toMovie(MovieGetDTO dto);
}
