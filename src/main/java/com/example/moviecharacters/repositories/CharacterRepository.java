package com.example.moviecharacters.repositories;

import com.example.moviecharacters.models.Character;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
