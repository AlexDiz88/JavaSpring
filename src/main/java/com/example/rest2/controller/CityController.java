package com.example.rest2.controller;

import com.example.rest2.dto.CityRequestDTO;
import com.example.rest2.dto.CityResponseDTO;
import com.example.rest2.service.CityServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityController {

    private CityServiceImpl service;

    @GetMapping("")
    public List<CityResponseDTO> listCity() {
        return service.getAllCities();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public CityResponseDTO createCity(@RequestBody CityRequestDTO city) {
        return service.addCity(city);
    }

    @PutMapping("")
    public CityResponseDTO updateCity(@RequestBody Long id, CityRequestDTO city) {
        return service.updateCity(id, city);
    }


}
