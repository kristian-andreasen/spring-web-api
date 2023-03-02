package com.example.moviecharacters.mappers;
import com.example.moviecharacters.dto.character.FranchiseGetDTO;
import com.example.moviecharacters.models.Franchise;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {
    FranchiseGetDTO toFranchiseDto(Franchise franchise);
    Franchise toFranchise(FranchiseGetDTO dto);
}
