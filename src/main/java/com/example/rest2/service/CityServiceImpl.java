package com.example.rest2.service;

import com.example.rest2.dto.CityRequestDTO;
import com.example.rest2.dto.CityResponseDTO;
import com.example.rest2.entity.City;
import com.example.rest2.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CityServiceImpl {

    private CityRepository repository;

    public List<CityResponseDTO> getAllCities() {
        List<CityResponseDTO> list = new ArrayList<>();
        repository.findAll().forEach(
                c -> {
                    CityResponseDTO cdto = new CityResponseDTO(
                            c.getId(),
                            c.getName(),
                            c.getCountry(),
                            c.getPopulation(),
                            c.getArea()
                    );
                    list.add(cdto);
                }
        );
        return list;
    }

    public CityResponseDTO addCity(CityRequestDTO city) {
        City c = new City(
                null,
                city.getName(),
                city.getCountry(),
                city.getPopulation(),
                city.getArea()
                );
        repository.save(c);
        CityResponseDTO cdto = new CityResponseDTO();
        return cdto;
    }

    public CityResponseDTO updateCity(Long id, CityRequestDTO city){
        City updatedCity = repository.findById(id).get();
        updatedCity.setName(city.getName());
        updatedCity.setCountry(city.getCountry());
        updatedCity.setPopulation(city.getPopulation());
        updatedCity.setArea(city.getArea());

        CityResponseDTO cityResponseDTO = new CityResponseDTO();

        return  cityResponseDTO;
    }

}
