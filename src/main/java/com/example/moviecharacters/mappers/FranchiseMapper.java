package com.example.moviecharacters.mappers;

import com.example.moviecharacters.dto.FranchiseDTO;
import com.example.moviecharacters.dto.FranchiseGetDTO;
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
    FranchiseDTO franchiseDTO(Franchise franchise);

    @Mapping(target = "movies", ignore = true)
    Franchise franchiseDtoToFranchise(FranchiseDTO franchiseDTO);

    /**
     * Maps a Franchise entity to a FranchiseGetDTO data transfer object.
     * The 'movies' field in the Franchise entity is mapped to the 'movies' field in the FranchiseGetDTO object
     * using a custom mapping method 'moviesToNames'.
     *
     * @param franchise the Franchise entity to map
     * @return the mapped FranchiseGetDTO object
     */
    @Mapping(target = "movies", source = "movies", qualifiedByName = "moviesToNames")
    FranchiseGetDTO toFranchiseDto(Franchise franchise);

    /**
     * Maps a collection of Franchise entities to a collection of FranchiseGetDTO data transfer objects.
     *
     * @param franchises the collection of Franchise entities to map
     * @return the collection of mapped FranchiseGetDTO objects
     */
    Collection<FranchiseGetDTO> toFranchiseDto(Collection<Franchise> franchises);



    /**
     * This is a custom mapping method that maps a set of Movie entities to a set of movie names.
     * It is used to map the 'movies' field in the Franchise entity to the 'movies' field in the FranchiseGetDTO object.
     *
     * @param source the set of Movie entities to map
     * @return the set of mapped movie names
     */
    @Named("moviesToNames")
    default Set<String> map(Set<Movie> source) {
        if (source == null) return null;
        return source.stream().map(s -> s.getName()).collect(Collectors.toSet());
    }
}
