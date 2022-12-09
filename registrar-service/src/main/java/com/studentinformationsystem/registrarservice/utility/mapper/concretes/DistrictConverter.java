package com.studentinformationsystem.registrarservice.utility.mapper.concretes;

import com.studentinformationsystem.registrarservice.dto.district.CreateDistrictRequest;
import com.studentinformationsystem.registrarservice.dto.district.DistrictDto;
import com.studentinformationsystem.registrarservice.dto.district.UpdateDistrictRequest;
import com.studentinformationsystem.registrarservice.model.City;
import com.studentinformationsystem.registrarservice.model.District;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.DistrictMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DistrictConverter implements DistrictMapper {
    @Override
    public DistrictDto toDistrictDto(District from) {
        return DistrictDto
                .builder()
                .name(from.getName())
                .build();
    }

    @Override
    public List<DistrictDto> toDistrictDtoList(List<District> from) {
        return from.stream()
                .map(
                        district -> toDistrictDto(district)
                        )
                .collect(Collectors.toList());
    }

    @Override
    public District toDistrict(CreateDistrictRequest request) {
        return District.builder()
                .name(request.getName())
                .city(City.builder()
                        .id(request.getCityId())
                        .build())
                .build();
    }

    @Override
    public District toDistrict(UpdateDistrictRequest request) {
        return District.builder()
                .name(request.getName())
                .build();
    }
}
