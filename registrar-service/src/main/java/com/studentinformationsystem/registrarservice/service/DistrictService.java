package com.studentinformationsystem.registrarservice.service;

import com.studentinformationsystem.registrarservice.dto.district.CreateDistrictRequest;
import com.studentinformationsystem.registrarservice.dto.district.DistrictDto;
import com.studentinformationsystem.registrarservice.dto.district.UpdateDistrictRequest;

import java.util.List;

public interface DistrictService {
    DistrictDto create(CreateDistrictRequest request);

    //DistrictDto delete (String districtId);
    DistrictDto update(UpdateDistrictRequest request);

    List<DistrictDto> getAll();

    DistrictDto getById(String districtId);
}
