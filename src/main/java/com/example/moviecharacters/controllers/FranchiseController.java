package com.example.moviecharacters.controllers;
import com.example.moviecharacters.models.Franchise;
import com.example.moviecharacters.repositories.FranchiseRepository;
import com.example.moviecharacters.services.FranchiseServiceImpl;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/franchises") //base path
@RestController
public class FranchiseController {
    private final FranchiseServiceImpl franchiseService;
    private final FranchiseRepository franchiseRepository;

    public FranchiseController(FranchiseServiceImpl franchiseService, FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
        this.franchiseService = franchiseService;
    }

    @GetMapping()
    public Iterable<Franchise> getAllFranchises() {
        return franchiseService.findAll();
    }

    @GetMapping("/{id}")
    public Franchise getFranchiseById(@PathVariable int id) {
        return franchiseService.findById(id);

        /*if (franchise.isPresent()) {
            return franchise.get();
        } else {
            // throw a ResponseStatusException with a NOT_FOUND status code and a message.
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Franchise not found");
        }*/
    }

    @PostMapping()
    public Franchise createFranchise(@RequestBody Franchise franchise) {
        return franchiseService.add(franchise);
    }

    @PutMapping("/{id}")
    public Franchise updateFranchise(@PathVariable int id, @RequestBody Franchise updatedFranchise) {
        Franchise existingFranchise = franchiseService.findById(id);

        //update properties with new values
        existingFranchise.setId(updatedFranchise.getId());
        existingFranchise.setName(updatedFranchise.getName());
        existingFranchise.setDescription(updatedFranchise.getDescription());
        existingFranchise.setMovies(updatedFranchise.getMovies());

        //not sure about this though...
        return franchiseRepository.save(existingFranchise);
    }

    @DeleteMapping("/{id}")
    public void deleteFranchise(@PathVariable int id) {
        franchiseService.deleteById(id);

    }
}
