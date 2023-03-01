package com.example.moviecharacters.models;

import com.example.moviecharacters.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "full_name", length = 50, nullable = false)
    private String full_name;
    @Column(name = "character_gender")
    @Enumerated(EnumType.STRING)
    private Gender character_gender;
    @Column(name = "alias", length = 50)
    private String alias;
    @Column(name = "character_picture", length = 50)
    private String character_picture;

    @Column(name = "movie")
    @ManyToMany(mappedBy = "characterSet")
    private Set<Movie> movieSet;




}
