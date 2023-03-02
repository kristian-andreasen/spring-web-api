package com.example.moviecharacters;

import com.example.moviecharacters.models.Movie;
import com.example.moviecharacters.repositories.MovieRepository;
import com.example.moviecharacters.runners.AppRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class MovieCharactersApplication implements ApplicationRunner {



    public static void main(String[] args) {
        SpringApplication.run(MovieCharactersApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

}
