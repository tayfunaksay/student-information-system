package com.studentinformationsystem.detailservice.service;

import com.studentinformationsystem.detailservice.dto.district.CreateDistrictRequest;
import com.studentinformationsystem.detailservice.dto.district.DistrictDto;
import com.studentinformationsystem.detailservice.dto.district.UpdateDistrictRequest;

import java.util.List;

public interface DistrictService {
    DistrictDto create(CreateDistrictRequest request);

    DistrictDto update(UpdateDistrictRequest request);

    List<DistrictDto> getAllByCityId(String cityId);

    DistrictDto getById(String districtId);
}
