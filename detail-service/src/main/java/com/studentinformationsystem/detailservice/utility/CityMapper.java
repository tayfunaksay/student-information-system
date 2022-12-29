package com.studentinformationsystem.detailservice.utility;

import com.studentinformationsystem.detailservice.dto.city.CityDto;
import com.studentinformationsystem.detailservice.dto.city.CreateCityRequest;
import com.studentinformationsystem.detailservice.dto.city.UpdateCityRequest;
import com.studentinformationsystem.detailservice.model.City;

import java.util.List;

public interface CityMapper {
    CityDto toCityDto(City from);

    List<CityDto> toCityDtoList(List<City> from);

    City toCity(CreateCityRequest request);

    City toCity(UpdateCityRequest request);
}
