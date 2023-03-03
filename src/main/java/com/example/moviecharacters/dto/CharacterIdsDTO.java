package com.example.moviecharacters.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
public class CharacterIdsDTO {
    Set<Integer> characters;
}
