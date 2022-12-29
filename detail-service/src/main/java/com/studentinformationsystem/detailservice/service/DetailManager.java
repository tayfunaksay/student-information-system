package com.studentinformationsystem.detailservice.service;

import com.studentinformationsystem.detailservice.dto.detail.DetailDto;
import com.studentinformationsystem.detailservice.dto.detail.UpdateDetailRequest;
import com.studentinformationsystem.detailservice.exception.DetailNotFoundException;
import com.studentinformationsystem.detailservice.model.*;
import com.studentinformationsystem.detailservice.repository.DetailRepository;
import com.studentinformationsystem.detailservice.utility.DetailMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailManager implements DetailService {
    private final DetailRepository detailRepository;
    private final DetailMapper detailMapper;

    public DetailManager(DetailRepository detailRepository, DetailMapper detailMapper) {
        this.detailRepository = detailRepository;
        this.detailMapper = detailMapper;
    }

    @Override
    public String createDefaultDetail() {
        Detail defaultDetail = Detail.builder()
                .homeAddress(Address.builder().addressType(AddressType.HOME).city(City.builder().id("b1ed3a63-afad-4856-8ded-2b90819cd5c5").build()).district(District.builder().id("c299b97a-b197-4b08-8d9a-c069dd1d8e8b").build()).build())
                .workAddress(Address.builder().addressType(AddressType.WORK).city(City.builder().id("b1ed3a63-afad-4856-8ded-2b90819cd5c5").build()).district(District.builder().id("c299b97a-b197-4b08-8d9a-c069dd1d8e8b").build()).build())
                .build();
        Detail createdDetail =(detailRepository.save(defaultDetail));
        return createdDetail.getId();
    }

    @Override
    public DetailDto update(UpdateDetailRequest request) {
        if (detailRepository.existsById(request.getId())){
            return detailMapper.toDetailDto(detailRepository.save(detailMapper.toDetail(request)));
        }else {
            throw new DetailNotFoundException("Detail could not found by id: "+ request.getId());
        }
    }

    @Override
    public List<DetailDto> getAll() {
        return detailMapper.toDetailDtoList(detailRepository.findAll());
    }

    @Override
    public DetailDto getById(String detailId) {
        return detailMapper.toDetailDto(detailRepository.findById(detailId)
                .orElseThrow(()-> new DetailNotFoundException("Detail could not found by id: "+ detailId)));
    }
}
