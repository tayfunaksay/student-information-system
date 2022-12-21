package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.city.CityDto;
import com.studentinformationsystem.registrarservice.dto.city.CreateCityRequest;
import com.studentinformationsystem.registrarservice.dto.city.UpdateCityRequest;
import com.studentinformationsystem.registrarservice.exception.CityNotFoundException;
import com.studentinformationsystem.registrarservice.repository.CityRepository;
import com.studentinformationsystem.registrarservice.service.CityService;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.CityMapper;
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
        if (cityRepository.findById(request.getId()).isEmpty()) {
            throw new CityNotFoundException("City could not found by id: " + request.getId());
        } else {
            return cityMapper.toCityDto(cityRepository.save(cityMapper.toCity(request)));
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
