package com.example.moviecharacters.repositories;

import com.example.moviecharacters.models.Franchise;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {
}
