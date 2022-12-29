package com.studentinformationsystem.detailservice.utility;

import com.studentinformationsystem.detailservice.dto.district.CreateDistrictRequest;
import com.studentinformationsystem.detailservice.dto.district.DistrictDto;
import com.studentinformationsystem.detailservice.dto.district.UpdateDistrictRequest;
import com.studentinformationsystem.detailservice.model.District;

import java.util.List;

public interface DistrictMapper {
    DistrictDto toDistrictDto(District from);

    List<DistrictDto> toDistrictDtoList(List<District> from);

    District toDistrict(CreateDistrictRequest request);

    District toDistrict(UpdateDistrictRequest request);
}
