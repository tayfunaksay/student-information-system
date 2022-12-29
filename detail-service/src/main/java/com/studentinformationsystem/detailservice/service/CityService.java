package com.studentinformationsystem.detailservice.service;

import com.studentinformationsystem.detailservice.dto.city.CityDto;
import com.studentinformationsystem.detailservice.dto.city.CreateCityRequest;
import com.studentinformationsystem.detailservice.dto.city.UpdateCityRequest;

import java.util.List;

public interface CityService {

    CityDto create(CreateCityRequest request);

    //void delete (String cityId);
    CityDto update(UpdateCityRequest request);

    List<CityDto> getAll();

    CityDto getById(String cityId);
}
