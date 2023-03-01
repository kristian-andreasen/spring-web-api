package com.example.moviecharacters.repositories;

import com.example.moviecharacters.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

  /*  @Modifying
    @Query("update Movie m set m.characterSet = ?2 where m.id = ?1")
    void updateMovieById(Set charterSet, int movieId);*/

}
