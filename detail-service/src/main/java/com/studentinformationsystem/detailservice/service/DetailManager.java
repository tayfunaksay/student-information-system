package com.studentinformationsystem.detailservice.service;

import com.studentinformationsystem.detailservice.dto.detail.CreateDefaultDetailRequest;
import com.studentinformationsystem.detailservice.dto.detail.DetailDto;
import com.studentinformationsystem.detailservice.dto.detail.UpdateDetailRequest;
import com.studentinformationsystem.detailservice.exception.DetailNotFoundException;
import com.studentinformationsystem.detailservice.repository.DetailRepository;
import com.studentinformationsystem.detailservice.utility.DetailMapper;
import org.springframework.stereotype.Service;

@Service
public class DetailManager implements DetailService {
    private final DetailRepository detailRepository;
    private final DetailMapper detailMapper;

    public DetailManager(DetailRepository detailRepository, DetailMapper detailMapper) {
        this.detailRepository = detailRepository;
        this.detailMapper = detailMapper;
    }

    @Override
    public String createDefaultDetail(CreateDefaultDetailRequest request) {

        return detailMapper.toDetailDto(detailRepository.save(detailMapper.toDefaultDetail(request))).getId();
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
    public DetailDto getById(String detailId) {
        return detailMapper.toDetailDto(detailRepository.findById(detailId)
                .orElseThrow(()-> new DetailNotFoundException("Detail could not found by id: "+ detailId)));
    }
}
