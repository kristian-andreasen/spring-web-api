package com.example.moviecharacters.controllers;

import com.example.moviecharacters.models.Franchise;
import com.example.moviecharacters.repositories.FranchiseRepository;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

//HTTP methods
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.server.ResponseStatusException;

@RequestMapping("/api/v1/franchises") //base path
@RestController
public class FranchiseController {
    private final FranchiseRepository franchiseRepository;

    public FranchiseController(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    @GetMapping()
    public Iterable<Franchise> getSuperHeros() {
        return franchiseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Franchise getFranchiseById(@PathVariable Long id) {
        //return franchiseRepository.findByID(id);

        /*if (franchise.isPresent()) {
            return franchise.get();
        } else {
            // throw a ResponseStatusException with a NOT_FOUND status code and a message.
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Franchise not found");
        }*/
    }
}
