package com.example.moviecharacters.dto;

import com.example.moviecharacters.models.Movie;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * This class represents a Franchise data transfer object used for transferring Franchise information through the API.
 * It contains only the necessary information to be sent through the API and omits any sensitive or unnecessary data.
 */
@Data
@Getter
@Setter
public class FranchiseGetDTO {
    private int id;
    private String name;
    private String description;
    private Set<String> movies; // Set of movie names related to the franchise
}
