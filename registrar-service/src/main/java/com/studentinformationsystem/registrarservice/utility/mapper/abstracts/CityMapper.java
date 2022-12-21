package com.studentinformationsystem.registrarservice.utility.mapper.abstracts;

import com.studentinformationsystem.registrarservice.dto.city.CityDto;
import com.studentinformationsystem.registrarservice.dto.city.CreateCityRequest;
import com.studentinformationsystem.registrarservice.dto.city.UpdateCityRequest;
import com.studentinformationsystem.registrarservice.model.City;

import java.util.List;

public interface CityMapper {
    CityDto toCityDto(City from);

    List<CityDto> toCityDtoList(List<City> from);

    City toCity(CreateCityRequest request);

    City toCity(UpdateCityRequest request);
}
