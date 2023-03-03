package com.example.moviecharacters.mappers;
import com.example.moviecharacters.dto.CharacterIdsDTO;
import com.example.moviecharacters.dto.MovieCreateDTO;
import com.example.moviecharacters.dto.MovieGetDTO;
import com.example.moviecharacters.dto.MovieUpdateDTO;
import com.example.moviecharacters.models.Character;
import com.example.moviecharacters.models.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;


import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(target = "franchise", source = "franchise.id")
    @Mapping(target = "characters", source = "characters", qualifiedByName = "charactersToIds")
    MovieGetDTO toMovieDto(Movie movie);

    @Mapping(target = "characters", ignore = true)
    Movie toMovie(MovieCreateDTO movieCreateDTO);

  //  @Mapping(target = "characters", ignore = true)
    void updateMovieFromDto(MovieUpdateDTO movieUpdateDTO, @MappingTarget Movie movie);

  //  @Mapping(target = "characters", ignore = true)
   // void updateCharactersInMovieFromDto(CharacterIdsDTO characterIdsDTO, @MappingTarget Movie movie);
    
    /*default Movie toMovie(MovieGetDTO dto) {

    }*/

    @Named("charactersToIds")
    default Set<Integer> map(Set<Character> source) {
        if(source == null)
            return null;
        return source.stream()
                .map(s -> s.getId()).collect(Collectors.toSet());
    }
}
