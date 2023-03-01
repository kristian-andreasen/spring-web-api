package com.example.moviecharacters.repositories;

import com.example.moviecharacters.models.Character;

import com.example.moviecharacters.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface CharacterRepository extends JpaRepository<Character, Integer> {

   /* @Modifying
    @Query("update Character c set c.movieSet = ?2 where c.id = ?1")
    void updateCharacterById(Set<Movie> movieSet, int characterId);*/

}
