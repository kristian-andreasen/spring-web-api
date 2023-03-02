package com.example.moviecharacters.mappers;

import com.example.moviecharacters.dto.character.FranchiseGetDTO;
import com.example.moviecharacters.models.Franchise;
import com.example.moviecharacters.models.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {
    //@Mapping(target = "movies", source = "movies")
    @Mapping(target = "movies", source = "movies", qualifiedByName = "moviesToNames")
    FranchiseGetDTO toFranchiseDto(Franchise franchise);


    Collection<FranchiseGetDTO> toFranchiseDto(Collection<Franchise> franchises);



    @Named("moviesToNames")
    default Set<String> map(Set<Movie> source) {
        if (source == null) return null;
        return source.stream().map(s -> s.getName()).collect(Collectors.toSet());
    }
}
