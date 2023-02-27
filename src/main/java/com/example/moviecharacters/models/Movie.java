package com.example.moviecharacters.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.mapping.List;

import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "tb_movie")
public class Movie {
    @Id
    @Column(name = "movie_id")
    private int id;
    @Column(name = "movie_title", length = 50, nullable = false)
    private String name;
    @Column(name = "genre", length = 50)
    private String genre;
    @Column(name = "release_year")
    private Date release_year;
    @Column(name = "director", length = 50)
    private String director;
    @Column(name = "movie_picture", length = 50)
    private String movie_picture;
    @Column(name = "trailer", length = 50)
    private String trailer;

}
