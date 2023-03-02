package com.example.moviecharacters.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "franchises")
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "franchise_name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", columnDefinition="TEXT")
    private String description;

    @OneToMany(mappedBy = "franchise")
    private Set<Movie> movies;
}
