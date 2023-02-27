package com.example.moviecharacters.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Franchise {
    @Id
    @Column(name = "franchise_id")
    private int id;
    @Column(name = "franchise_name", length = 50, nullable = false)
    private String name;
    @Column(name = "description", columnDefinition="TEXT")
    private String description;
}
