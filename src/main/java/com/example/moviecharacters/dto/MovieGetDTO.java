package com.example.moviecharacters.dto;

import com.example.moviecharacters.models.Character;
import com.example.moviecharacters.models.Franchise;
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
    private int franchise;
    private Set<Integer> characters; //Integer?

    public int getId(){
        return id;
    }
}
