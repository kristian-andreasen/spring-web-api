package com.example.moviecharacters.services;

import com.example.moviecharacters.models.Character;
import com.example.moviecharacters.models.Movie;
import com.example.moviecharacters.repositories.CharacterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;


@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;

    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public Character findById(Integer id) {
        return characterRepository.findById(id).get();
    }

    @Override
    public Collection<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public Character add(Character entity) {
        return characterRepository.save(entity);
    }

    @Override
    public Character update(Character entity) {
        return characterRepository.save(entity);
    }

    @Override
    public void deleteById(Integer integer) {

    }

    /*@Override
    public void deleteById(Integer id) {
        if (characterRepository.existsById(id)) {
            Character character = characterRepository.findById(id).get();
            character.getMovieSet().forEach(s -> s.setCharacterSet(null));
            character.getMovieSet().forEach(s -> s.setCharacterSet(null));
            characterRepository.delete(character);
        } else {
            logger.warn("No character exists with ID: " + id);
            characterRepository.deleteById(id);
        }
    }*/

}
