package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.district.CreateDistrictRequest;
import com.studentinformationsystem.registrarservice.dto.district.DistrictDto;
import com.studentinformationsystem.registrarservice.dto.district.UpdateDistrictRequest;
import com.studentinformationsystem.registrarservice.service.DistrictService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictManager implements DistrictService {
    @Override
    public DistrictDto create(CreateDistrictRequest request) {
        return null;
    }

    @Override
    public DistrictDto update(UpdateDistrictRequest request) {
        return null;
    }

    @Override
    public List<DistrictDto> getAll() {
        return null;
    }

    @Override
    public DistrictDto getById(String districtId) {
        return null;
    }
}
