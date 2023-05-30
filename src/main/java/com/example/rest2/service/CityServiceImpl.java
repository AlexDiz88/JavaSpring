package com.example.rest2.service;

import com.example.rest2.dto.CityRequestDTO;
import com.example.rest2.dto.CityResponseDTO;
import com.example.rest2.entity.City;
import com.example.rest2.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CityServiceImpl {

    private CityRepository cityRepository;

    public List<CityResponseDTO> getAllCities() {
        List<CityResponseDTO> list = new ArrayList<>();
        cityRepository.findAll().forEach(
                c -> {
                    CityResponseDTO cityResponseDTO = new CityResponseDTO(
                            c.getId(), c.getName(), c.getCountry(), c.getPopulation(), c.getArea()
                    );
                    list.add(cityResponseDTO);
                }
        );
        return list;
    }

    public CityResponseDTO getCity(Long id) {
        City city = cityRepository.findById(id).get();
        return new CityResponseDTO(
                city.getId(), city.getName(), city.getCountry(), city.getPopulation(), city.getArea()
        );
    }

    public CityResponseDTO addCity(CityRequestDTO cityDTO) {
        City city = new City(
                null,
                cityDTO.getName(),
                cityDTO.getCountry(),
                cityDTO.getPopulation(),
                cityDTO.getArea()
        );
        cityRepository.save(city);
        return new CityResponseDTO(); // почему возвращаем пустой объект??
    }

    public CityResponseDTO updateCity(Long id, CityRequestDTO cityDTO) {
        City city = cityRepository.findById(id).get();
        city.setName(cityDTO.getName());
        city.setCountry(cityDTO.getCountry());
        city.setPopulation(cityDTO.getPopulation());
        city.setArea(cityDTO.getArea());

        cityRepository.save(city);

        return new CityResponseDTO(
                city.getId(), city.getName(), city.getCountry(), city.getPopulation(), city.getArea()
        );
    }


    public CityResponseDTO deleteCity(Long id) {
        City city = cityRepository.findById(id).get();
        cityRepository.deleteById(id);
        return new CityResponseDTO(
                city.getId(), city.getName(), city.getCountry(), city.getPopulation(), city.getArea()
        );
    }
}
