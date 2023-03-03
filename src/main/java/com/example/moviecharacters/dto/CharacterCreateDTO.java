package com.example.moviecharacters.dto;

import com.example.moviecharacters.enums.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CharacterCreateDTO {
    private String full_name;
    private Gender character_gender;
    private String alias;
    private String character_picture;
}
