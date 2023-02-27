package com.example.moviecharacters.models;

import jakarta.persistence.*;

import org.hibernate.mapping.List;


import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tb_movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "movie_title", length = 50, nullable = false)
    private String name;
    @Column(name = "genre", length = 50)
    private String genre;
    @Column(name = "release_year")
    private int release_year;
    @Column(name = "director", length = 50)
    private String director;
    @Column(name = "movie_picture", length = 500)
    private String movie_picture;
    @Column(name = "trailer", length = 500)
    private String trailer;
    @Column(name = "character")
    @ManyToMany
            //(mappedBy = "movie")
    private Set<Character> character;
    @Column(name = "franchise", length = 50)
    private String franchise;

}
