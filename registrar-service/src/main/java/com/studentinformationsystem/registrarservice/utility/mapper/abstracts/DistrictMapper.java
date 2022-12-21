package com.studentinformationsystem.registrarservice.utility.mapper.abstracts;

import com.studentinformationsystem.registrarservice.dto.district.CreateDistrictRequest;
import com.studentinformationsystem.registrarservice.dto.district.DistrictDto;
import com.studentinformationsystem.registrarservice.dto.district.UpdateDistrictRequest;
import com.studentinformationsystem.registrarservice.model.District;

import java.util.List;

public interface DistrictMapper {
    DistrictDto toDistrictDto(District from);

    List<DistrictDto> toDistrictDtoList(List<District> from);

    District toDistrict(CreateDistrictRequest request);

    District toDistrict(UpdateDistrictRequest request);
}
