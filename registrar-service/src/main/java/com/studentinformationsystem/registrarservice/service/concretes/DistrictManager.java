package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.district.CreateDistrictRequest;
import com.studentinformationsystem.registrarservice.dto.district.DistrictDto;
import com.studentinformationsystem.registrarservice.dto.district.UpdateDistrictRequest;
import com.studentinformationsystem.registrarservice.exception.DistrictNotFoundException;
import com.studentinformationsystem.registrarservice.repository.DistrictRepository;
import com.studentinformationsystem.registrarservice.service.DistrictService;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.DistrictMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictManager implements DistrictService {

    private final DistrictMapper districtMapper;
    private final DistrictRepository districtRepository;

    public DistrictManager(DistrictMapper districtMapper, DistrictRepository districtRepository) {
        this.districtMapper = districtMapper;
        this.districtRepository = districtRepository;
    }

    @Override
    public DistrictDto create(CreateDistrictRequest request) {
        return districtMapper.toDistrictDto(districtRepository.save(districtMapper.toDistrict(request)));
    }

    @Override
    public DistrictDto update(UpdateDistrictRequest request) {
        if (districtRepository.findById(request.getId()).isEmpty()) {
            throw new DistrictNotFoundException("District could not found by id: " + request.getId());
        } else {
            return districtMapper.toDistrictDto(districtRepository.save(districtMapper.toDistrict(request)));
        }
    }

    @Override
    public List<DistrictDto> getAll() {
        return districtMapper.toDistrictDtoList(districtRepository.findAll());
    }

    @Override
    public DistrictDto getById(String districtId) {
        return districtMapper.toDistrictDto(districtRepository.findById(districtId)
                .orElseThrow(() -> new DistrictNotFoundException("District could not found by id: " + districtId)));
    }
}
