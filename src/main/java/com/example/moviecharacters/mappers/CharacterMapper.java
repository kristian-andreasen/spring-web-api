package com.example.moviecharacters.mappers;
import com.example.moviecharacters.dto.character.CharacterGetDTO;
import com.example.moviecharacters.models.Character;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    CharacterGetDTO toCharacterDto(Character character);
    Character toCharacter(CharacterGetDTO dto);
}
