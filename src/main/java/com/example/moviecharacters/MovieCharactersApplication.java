package com.example.moviecharacters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class MovieCharactersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieCharactersApplication.class, args);
    }

}
