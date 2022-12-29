package com.studentinformationsystem.detailservice.utility;

import com.studentinformationsystem.detailservice.dto.city.CityDto;
import com.studentinformationsystem.detailservice.dto.city.CreateCityRequest;
import com.studentinformationsystem.detailservice.dto.city.UpdateCityRequest;
import com.studentinformationsystem.detailservice.model.City;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityConverter implements CityMapper {

    @Override
    public CityDto toCityDto(City from) {
        return CityDto.builder()
                .id(from.getId())
                .name(from.getName())
                .plateNumber(from.getPlateNumber())
                .build();
    }

    @Override
    public List<CityDto> toCityDtoList(List<City> from) {
        return from.stream()
                .map(city -> toCityDto(city))
                .collect(Collectors.toList());
    }

    @Override
    public City toCity(CreateCityRequest request) {
        return City.builder()
                .name(request.getName())
                .plateNumber(request.getPlateNumber())
                .build();
    }

    @Override
    public City toCity(UpdateCityRequest request) {
        return City.builder()
                .id(request.getId())
                .name(request.getName())
                .plateNumber(request.getPlateNumber())
                .build();
    }
}
