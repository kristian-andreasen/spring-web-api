package com.example.moviecharacters.controllers;
import com.example.moviecharacters.dto.character.FranchiseGetDTO;
import com.example.moviecharacters.mappers.FranchiseMapper;
import com.example.moviecharacters.models.Franchise;
import com.example.moviecharacters.repositories.FranchiseRepository;
import com.example.moviecharacters.services.FranchiseServiceImpl;
import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/franchises") //base path
@RestController
public class FranchiseController {
    private final FranchiseServiceImpl franchiseService;
    private final FranchiseMapper franchiseMapper;

    public FranchiseController(FranchiseServiceImpl franchiseService,FranchiseMapper franchiseMapper) {
        this.franchiseMapper = franchiseMapper;
        this.franchiseService = franchiseService;
    }

    /*@GetMapping()
    public ResponseEntity<FranchiseGetDTO> getAllFranchises() {
        FranchiseGetDTO franchiseGetDTO = franchiseMapper.toFranchiseDto(franchiseService.findAll());
        return ResponseEntity.ok(franchiseGetDTO);
    }*/


    @GetMapping("/{id}")
    public ResponseEntity<FranchiseGetDTO> getFranchiseById(@PathVariable int id) {
        FranchiseGetDTO franchiseGetDTO = franchiseMapper.toFranchiseDto(franchiseService.findById(id));
        return ResponseEntity.ok(franchiseGetDTO);
    }

    @PostMapping()
    public Franchise createFranchise(@RequestBody Franchise franchise) {
        return franchiseService.add(franchise);
    }

    /*@PutMapping("/{id}")
    public Franchise updateFranchise(@PathVariable int id, @RequestBody Franchise updatedFranchise) {
        Franchise existingFranchise = franchiseService.findById(id);

        //update properties with new values
        existingFranchise.setId(updatedFranchise.getId());
        existingFranchise.setName(updatedFranchise.getName());
        existingFranchise.setDescription(updatedFranchise.getDescription());
        existingFranchise.setMovies(updatedFranchise.getMovies());

        //not sure about this though...
        return franchiseRepository.save(existingFranchise);
    }*/

    @DeleteMapping("/{id}")
    public void deleteFranchise(@PathVariable int id) {
        franchiseService.deleteById(id);

    }
}
