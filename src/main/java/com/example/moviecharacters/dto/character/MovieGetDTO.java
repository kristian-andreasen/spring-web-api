package com.example.moviecharacters.dto.character;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
public class MovieGetDTO {
    private int id;
    private String name;
    private String genre;
    private int release_year;
    private String director;
    private String movie_picture;
    private String trailer;
    private Set<Integer> characters; //Integer?
}
