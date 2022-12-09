package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.city.CityDto;
import com.studentinformationsystem.registrarservice.dto.city.CreateCityRequest;
import com.studentinformationsystem.registrarservice.dto.city.UpdateCityRequest;
import com.studentinformationsystem.registrarservice.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {
    @Override
    public CityDto create(CreateCityRequest request) {
        return null;
    }

    @Override
    public CityDto update(UpdateCityRequest request) {
        return null;
    }

    @Override
    public List<CityDto> getAll() {
        return null;
    }

    @Override
    public CityDto getById(long cityId) {
        return null;
    }
}
