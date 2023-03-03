package com.example.moviecharacters.controllers;
import com.example.moviecharacters.dto.FranchiseCreateDTO;
import com.example.moviecharacters.dto.FranchiseGetDTO;
import com.example.moviecharacters.dto.FranchiseUpdateDTO;
import com.example.moviecharacters.mappers.FranchiseMapper;
import com.example.moviecharacters.models.Franchise;
import com.example.moviecharacters.services.FranchiseServiceImpl;
import com.example.moviecharacters.util.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/api/v1/franchises") //base path
@RestController
public class FranchiseController {
    private final FranchiseServiceImpl franchiseService;
    private final FranchiseMapper franchiseMapper;

    public FranchiseController(FranchiseServiceImpl franchiseService,FranchiseMapper franchiseMapper) {
        this.franchiseMapper = franchiseMapper;
        this.franchiseService = franchiseService;
    }

    @Operation(summary = "Get all franchises")
    @GetMapping()
    public ResponseEntity getAllFranchises() {
        Collection<FranchiseGetDTO> studs = franchiseMapper.toFranchiseDto(
                franchiseService.findAll());
        return ResponseEntity.ok(studs);
    }

    @Operation(summary = "Get a franchise by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FranchiseGetDTO.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Franchise does not exist with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("/{id}")
    public ResponseEntity<FranchiseGetDTO> getFranchiseById(@PathVariable int id) {
        FranchiseGetDTO franchiseGetDTO = franchiseMapper.toFranchiseDto(franchiseService.findById(id));
        return ResponseEntity.ok(franchiseGetDTO);
    }

    @Operation(summary = "Creates one franchise")
    @PostMapping
    public ResponseEntity<FranchiseGetDTO> createFranchise(@RequestBody FranchiseCreateDTO franchiseCreateDTO) {
        // Create a new Franchise object and set its name and description based on the DTO
        Franchise franchise = new Franchise();
        franchise.setName(franchiseCreateDTO.getName());
        franchise.setDescription(franchiseCreateDTO.getDescription());

        // Save the new franchise using the FranchiseService
        Franchise savedFranchise = franchiseService.add(franchise);

        // Map the saved franchise to a FranchiseGetDTO and return it in a ResponseEntity
        FranchiseGetDTO franchiseGetDTO = franchiseMapper.toFranchiseDto(savedFranchise);
        return ResponseEntity.ok(franchiseGetDTO);
    }

    @Operation(summary = "Updates a franchise")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "Franchise successfully updated",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Franchise not found with supplied ID",
                    content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> updateFranchise(@PathVariable int id, @RequestBody FranchiseUpdateDTO dto) {
        Franchise franchise = franchiseService.findById(id);

        if (franchise == null) {
            return ResponseEntity.notFound().build();
        }

        franchise.setName(dto.getName());
        franchise.setDescription(dto.getDescription());

        franchiseService.add(franchise);

        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Delete franchise")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteFranchise(@PathVariable int id) {

        if (franchiseService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        franchiseService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
