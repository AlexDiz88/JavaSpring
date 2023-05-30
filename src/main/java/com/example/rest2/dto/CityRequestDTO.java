package com.example.rest2.dto;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityRequestDTO {

    private String name;
    private String country;
    private int population;
    private double area;
}
