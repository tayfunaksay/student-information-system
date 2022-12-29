package com.studentinformationsystem.detailservice.utility;

import com.studentinformationsystem.detailservice.dto.district.CreateDistrictRequest;
import com.studentinformationsystem.detailservice.dto.district.DistrictDto;
import com.studentinformationsystem.detailservice.dto.district.UpdateDistrictRequest;
import com.studentinformationsystem.detailservice.model.City;
import com.studentinformationsystem.detailservice.model.District;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DistrictConverter implements DistrictMapper {
    @Override
    public DistrictDto toDistrictDto(District from) {
        return DistrictDto.builder()
                .id(from.getId())
                .name(from.getName())
                .build();
    }

    @Override
    public List<DistrictDto> toDistrictDtoList(List<District> from) {
        return from.stream()
                .map(district -> toDistrictDto(district))
                .collect(Collectors.toList());
    }

    @Override
    public District toDistrict(CreateDistrictRequest request) {
        return District.builder()
                .name(request.getName())
                .city(City.builder().id(request.getCityId()).build())
                .build();
    }

    @Override
    public District toDistrict(UpdateDistrictRequest request) {
        return District.builder()
                .name(request.getName())
                .build();
    }
}
