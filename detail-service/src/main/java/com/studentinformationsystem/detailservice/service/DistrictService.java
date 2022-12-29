package com.studentinformationsystem.detailservice.service;

import com.studentinformationsystem.detailservice.dto.district.CreateDistrictRequest;
import com.studentinformationsystem.detailservice.dto.district.DistrictDto;
import com.studentinformationsystem.detailservice.dto.district.UpdateDistrictRequest;

import java.util.List;

public interface DistrictService {
    DistrictDto create(CreateDistrictRequest request);

    //DistrictDto delete (String districtId);
    DistrictDto update(UpdateDistrictRequest request);

    List<DistrictDto> getAll();

    DistrictDto getById(String districtId);
}
