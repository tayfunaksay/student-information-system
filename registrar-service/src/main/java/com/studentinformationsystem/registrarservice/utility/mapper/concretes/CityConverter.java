package com.studentinformationsystem.registrarservice.utility.mapper.concretes;

import com.studentinformationsystem.registrarservice.dto.city.CityDto;
import com.studentinformationsystem.registrarservice.dto.city.CreateCityRequest;
import com.studentinformationsystem.registrarservice.dto.city.UpdateCityRequest;
import com.studentinformationsystem.registrarservice.model.City;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.CityMapper;
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
