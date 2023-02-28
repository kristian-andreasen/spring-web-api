package com.example.moviecharacters.services;

import com.example.moviecharacters.models.Franchise;
import com.example.moviecharacters.repositories.CharacterRepository;
import com.example.moviecharacters.repositories.FranchiseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FranchiseServiceImpl implements FranchiseService {

    private final FranchiseRepository franchiseRepository;

    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    @Override
    public Franchise findById(Integer integer) {
        return franchiseRepository.findById(integer).get();
    }

    @Override
    public Collection<Franchise> findAll() {
        return franchiseRepository.findAll();
    }

    @Override
    public Franchise add(Franchise entity) {
        return franchiseRepository.save(entity);
    }

    @Override
    public Franchise update(Franchise entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {
        franchiseRepository.deleteById(integer);
    }

    @Override
    public void delete(Franchise entity) {
        franchiseRepository.delete(entity);
    }
}
