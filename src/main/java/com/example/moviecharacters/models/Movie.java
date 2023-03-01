package com.example.moviecharacters.models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "tb_movie")
public class Movie {

    public Movie() {
    }

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
    private Set<Character> characterSet;

    @ManyToOne
    private Franchise franchise;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", release_year=" + release_year +
                ", director='" + director + '\'' +
                ", movie_picture='" + movie_picture + '\'' +
                ", trailer='" + trailer + '\'' +
                ", character=" + characterSet +
              //  ", franchise='" + franchise + '\'' +
                '}';
    }
}
