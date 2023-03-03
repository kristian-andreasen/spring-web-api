package com.example.moviecharacters.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class FranchiseUpdateDTO {
    private String name;
    private String description;
}
