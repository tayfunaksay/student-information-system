package com.studentinformationsystem.detailservice.service;

import com.studentinformationsystem.detailservice.dto.city.CityDto;
import com.studentinformationsystem.detailservice.dto.city.CreateCityRequest;
import com.studentinformationsystem.detailservice.dto.city.UpdateCityRequest;
import com.studentinformationsystem.detailservice.exception.CityNotFoundException;
import com.studentinformationsystem.detailservice.repository.CityRepository;
import com.studentinformationsystem.detailservice.utility.CityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public CityManager(CityRepository cityRepository, CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    @Override
    public CityDto create(CreateCityRequest request) {
        return cityMapper.toCityDto(cityRepository.save(cityMapper.toCity(request)));
    }

    @Override
    public CityDto update(UpdateCityRequest request) {
        if (cityRepository.existsById(request.getId())) {
            return cityMapper.toCityDto(cityRepository.save(cityMapper.toCity(request)));
        } else {
            throw new CityNotFoundException("City could not found by id: " + request.getId());
        }
    }

    @Override
    public List<CityDto> getAll() {
        return cityMapper.toCityDtoList(cityRepository.findAll());
    }

    @Override
    public CityDto getById(String cityId) {
        return cityMapper.toCityDto(cityRepository.findById(cityId)
                .orElseThrow(() -> new CityNotFoundException("City could not found by id: " + cityId)));
    }
}
