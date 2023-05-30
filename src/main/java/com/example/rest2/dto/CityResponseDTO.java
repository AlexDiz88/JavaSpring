package com.example.rest2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityResponseDTO {

    private Long Id;
    private String name;
    private String country;
    private int population;
    private double area;
}
