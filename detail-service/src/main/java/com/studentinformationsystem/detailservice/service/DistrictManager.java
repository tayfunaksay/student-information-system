package com.studentinformationsystem.detailservice.service;

import com.studentinformationsystem.detailservice.dto.district.CreateDistrictRequest;
import com.studentinformationsystem.detailservice.dto.district.DistrictDto;
import com.studentinformationsystem.detailservice.dto.district.UpdateDistrictRequest;
import com.studentinformationsystem.detailservice.exception.DistrictNotFoundException;
import com.studentinformationsystem.detailservice.repository.DistrictRepository;
import com.studentinformationsystem.detailservice.utility.DistrictMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictManager implements DistrictService {
    private final DistrictRepository districtRepository;
    private final DistrictMapper districtMapper;

    public DistrictManager(DistrictRepository districtRepository, DistrictMapper districtMapper) {
        this.districtRepository = districtRepository;
        this.districtMapper = districtMapper;
    }

    @Override
    public DistrictDto create(CreateDistrictRequest request) {
        return districtMapper.toDistrictDto(districtRepository.save(districtMapper.toDistrict(request)));
    }

    @Override
    public DistrictDto update(UpdateDistrictRequest request) {
        if (districtRepository.existsById(request.getId())){
            return districtMapper.toDistrictDto(districtRepository.save(districtMapper.toDistrict(request)));
        }else {
            throw new DistrictNotFoundException("District could not found by id: " +request.getId());
        }
    }

    @Override
    public List<DistrictDto> getAll() {
        return districtMapper.toDistrictDtoList(districtRepository.findAll());
    }

    @Override
    public DistrictDto getById(String districtId) {
        return districtMapper.toDistrictDto(districtRepository.findById(districtId)
                .orElseThrow(()-> new DistrictNotFoundException("District could not found by id: " + districtId)));
    }
}
