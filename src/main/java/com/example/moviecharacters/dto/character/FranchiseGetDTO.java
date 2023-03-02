package com.example.moviecharacters.dto.character;

import com.example.moviecharacters.models.Movie;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
public class FranchiseGetDTO {
    private int id;
    private String name;
    private String description;
    private Set<String> movies; //Integer?
}
