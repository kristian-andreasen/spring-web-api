package com.example.moviecharacters.controllers;

import com.example.moviecharacters.dto.CharacterCreateDTO;
import com.example.moviecharacters.dto.CharacterGetDTO;
import com.example.moviecharacters.dto.CharacterUpdateDTO;
import com.example.moviecharacters.mappers.CharacterMapper;
import com.example.moviecharacters.models.Character;
import com.example.moviecharacters.services.CharacterServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RequestMapping("/characters")
@RestController
public class CharacterController {
    private final CharacterServiceImpl characterService;
    private final CharacterMapper characterMapper;

    public CharacterController(CharacterServiceImpl characterService, CharacterMapper characterMapper) {
        this.characterService = characterService;
        this.characterMapper = characterMapper;
    }

    @Operation(summary = "Gets all of the characters")
    @GetMapping
    public ResponseEntity<Collection<CharacterGetDTO>> getAllCharacters() {
        Collection<CharacterGetDTO> characterDTOs = characterService.findAll()
                .stream()
                .map(characterMapper::toCharacterDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(characterDTOs);
    }

    @Operation(summary = "Gets a character by its id")
    @GetMapping("/{id}")
    public ResponseEntity<CharacterGetDTO> getCharacterById(@PathVariable int id) {
        CharacterGetDTO characterGetDTO = characterMapper.toCharacterDto(characterService.findById(id));
        return ResponseEntity.ok(characterGetDTO);
    }

    @Operation(summary = "Create a character and post it")
    @PostMapping
    public ResponseEntity<CharacterGetDTO> createCharacter(@RequestBody CharacterCreateDTO characterCreateDTO) {
        Character character = characterMapper.toCharacter(characterCreateDTO);
        Character savedCharacter = characterService.add(character);
        CharacterGetDTO characterDTO = characterMapper.toCharacterDto(savedCharacter);
        return ResponseEntity.status(HttpStatus.CREATED).body(characterDTO);
    }

    @Operation(summary = "Updates a character by a given id")
    @PutMapping("/{id}")
    public ResponseEntity<CharacterGetDTO> updateCharacter(@PathVariable int id, @RequestBody CharacterUpdateDTO characterUpdateDTO) {
        Character character = characterService.findById(id);
        if (character == null) {
            return ResponseEntity.notFound().build();
        }
        characterMapper.updateCharacterFromDto(characterUpdateDTO, character);
        Character updatedCharacter = characterService.update(character);
        CharacterGetDTO updatedCharacterDto = characterMapper.toCharacterDto(updatedCharacter);
        return ResponseEntity.ok(updatedCharacterDto);
    }

    @Operation(summary = "Deletes a character by a given id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Integer id) {
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
