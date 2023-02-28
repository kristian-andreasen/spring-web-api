package com.example.moviecharacters.runners;

import com.example.moviecharacters.models.Movie;
import com.example.moviecharacters.repositories.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {
    private final MovieRepository movieRepository;

    public AppRunner(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Movie movie = new Movie();
        movie.setName("Sausage party");

        //create
        movieRepository.save(movie);

        //read
        System.out.println(movieRepository.findById(2));

        //update
        Movie movie2 = movieRepository.findById(2).get();
        movie2.setGenre("adult");
        movieRepository.save(movie2);

        //delete
        movieRepository.deleteById(2);
    }
}
