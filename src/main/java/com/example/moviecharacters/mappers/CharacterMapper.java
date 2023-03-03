package com.example.moviecharacters.mappers;
import com.example.moviecharacters.dto.CharacterCreateDTO;
import com.example.moviecharacters.dto.CharacterGetDTO;
import com.example.moviecharacters.dto.CharacterUpdateDTO;
import com.example.moviecharacters.dto.MovieGetDTO;
import com.example.moviecharacters.models.Character;
import com.example.moviecharacters.models.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CharacterMapper {

    @Mapping(target = "movieIds", source = "movies", qualifiedByName = "mapMoviesToIds")
    CharacterGetDTO toCharacterDto(Character character);

  //  Collection<CharacterGetDTO> toCharacterDto(Collection<Character> characters);

    @Named("mapMoviesToIds")
    default Set<Integer> mapMoviesToIds(Set<Movie> source) {
        if (source == null) {
            return null;
        }
        return source.stream().map(Movie::getId).collect(Collectors.toSet());
    }

    @Mapping(target = "movies", ignore = true)
    Character toCharacter(CharacterCreateDTO characterCreateDTO);

    @Mapping(target = "movies", ignore = true)
    void updateCharacterFromDto(CharacterUpdateDTO characterUpdateDTO, @MappingTarget Character character);
}
