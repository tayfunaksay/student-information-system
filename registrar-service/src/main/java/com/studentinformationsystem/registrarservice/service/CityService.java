package com.studentinformationsystem.registrarservice.service;

import com.studentinformationsystem.registrarservice.dto.city.CityDto;
import com.studentinformationsystem.registrarservice.dto.city.CreateCityRequest;
import com.studentinformationsystem.registrarservice.dto.city.UpdateCityRequest;

import java.util.List;

public interface CityService {

    CityDto create (CreateCityRequest request);

    //CityDto delete (String cityId);
    CityDto update (UpdateCityRequest request);
    List<CityDto> getAll();
    CityDto getById(String cityId);
}
