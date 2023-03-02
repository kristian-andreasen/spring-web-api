package com.example.moviecharacters.dto.character;
import com.example.moviecharacters.enums.Gender;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
public class CharacterGetDTO {
    private int id;
    private String full_name;
    private Gender character_gender;
    private String alias;
    private String character_picture;
    private Set<Integer> movies; //Integer or Movie?
}
