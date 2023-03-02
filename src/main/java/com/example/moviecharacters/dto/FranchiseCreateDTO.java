package com.example.moviecharacters.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class FranchiseCreateDTO {
    private String name;
    private String description;
}
