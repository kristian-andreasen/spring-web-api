package com.example.moviecharacters.services;

import com.example.moviecharacters.models.Franchise;
import com.example.moviecharacters.repositories.CharacterRepository;
import com.example.moviecharacters.repositories.FranchiseRepository;
import jakarta.transaction.Transactional;
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
    public Franchise findById(Integer id) {
        return franchiseRepository.findById(id).get();
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
        return franchiseRepository.save(entity);
    }

    @Override
     @Transactional
    public void deleteById(Integer id) {
        if(franchiseRepository.existsById(id)) {
            Franchise fran = franchiseRepository.findById(id).get();
            fran.getMovies().forEach(m -> m.setFranchise(null));
            franchiseRepository.delete(fran);
        }
        else {
            logger.warn("No professor exists with ID: " + id);
        }
    }


}
