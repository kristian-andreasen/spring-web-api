package com.example.moviecharacters.services;

import com.example.moviecharacters.models.Character;
import com.example.moviecharacters.repositories.CharacterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class CharacterServiceImpl implements CharacterService{

    private final CharacterRepository characterRepository;

    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public Character findById(Integer integer) {
        return characterRepository.findById(integer).get();
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
        return null;
    }

    @Override
    public void deleteById(Integer integer) {
        characterRepository.deleteById(integer);
    }

    @Override
    public void delete(Character entity) {
        characterRepository.delete(entity);

    }
}
