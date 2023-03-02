package com.example.moviecharacters.mappers;
import com.example.moviecharacters.dto.character.FranchiseGetDTO;
import com.example.moviecharacters.models.Franchise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {
    @Mapping(target = "movies", source = "movies")
    FranchiseGetDTO toFranchiseDto(Franchise franchise);
    Franchise toFranchise(FranchiseGetDTO dto);
}
