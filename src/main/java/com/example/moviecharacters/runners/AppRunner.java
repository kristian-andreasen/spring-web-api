package com.example.moviecharacters.runners;

import com.example.moviecharacters.enums.Gender;
import com.example.moviecharacters.models.Character;
import com.example.moviecharacters.models.Franchise;
import com.example.moviecharacters.models.Movie;
import com.example.moviecharacters.services.CharacterService;
import com.example.moviecharacters.services.FranchiseService;
import com.example.moviecharacters.services.MovieService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {


    private final FranchiseService franchiseService;
    private final MovieService movieService;
    private final CharacterService characterService;

    public AppRunner(FranchiseService franchiseService, MovieService movieService, CharacterService characterService) {
        this.franchiseService = franchiseService;
        this.movieService = movieService;
        this.characterService = characterService;
    }

    @Override
        public void run(ApplicationArguments args) throws Exception {


        characterService.findAll();
        characterService.findById(1);
        Character character = new Character();
        character.setFull_name("Kristian Andreasen");
        characterService.add(character);
        character.setCharacter_gender(Gender.female);
        characterService.update(character);
        characterService.deleteById(1);

        movieService.findAll();
        movieService.findById(1);
        Movie movie = new Movie();
        movie.setName("Sharknado");
        movieService.add(movie);
        movie.setGenre("Action");
        movieService.update(movie);
        movieService.deleteById(1);

        System.out.println(franchiseService.findAll());
        franchiseService.findById(1);
        Franchise franchise = new Franchise();
        franchise.setName("Spy Kids");
        franchiseService.add(franchise);
        franchise.setDescription("the best franchise ever!!!");
        franchiseService.update(franchise);
        franchiseService.deleteById(1);
        }
}
