package com.example.rest2.controller;

import com.example.rest2.dto.CityRequestDTO;
import com.example.rest2.dto.CityResponseDTO;
import com.example.rest2.service.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityServiceImpl cityService;

    @Autowired
    public CityController(CityServiceImpl cityService) {
        this.cityService = cityService;
    }

    @GetMapping("")
    public List<CityResponseDTO> cityList() {
        return cityService.getAllCities();
    }

    @GetMapping(value = "/{id}")
    public CityResponseDTO getCity(@PathVariable Long id) {
        return cityService.getCity(id);
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public CityResponseDTO createCity(@RequestBody CityRequestDTO cityDTO) {
        return cityService.addCity(cityDTO);
    }

    @PutMapping(value = "/{id}")
    public CityResponseDTO updateCity(@PathVariable Long id, @RequestBody CityRequestDTO cityDTO) {
        return cityService.updateCity(id, cityDTO);
    }

    @DeleteMapping(value = "/{id}")
    public CityResponseDTO deleteCity(@PathVariable Long id) {
        return cityService.deleteCity(id);
    }



}
