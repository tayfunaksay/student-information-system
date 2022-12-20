package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.detail.CreateDetailRequest;
import com.studentinformationsystem.registrarservice.dto.detail.DetailDto;
import com.studentinformationsystem.registrarservice.dto.detail.UpdateDetailRequest;
import com.studentinformationsystem.registrarservice.exception.DetailNotFoundException;
import com.studentinformationsystem.registrarservice.repository.DetailRepository;
import com.studentinformationsystem.registrarservice.service.AddressService;
import com.studentinformationsystem.registrarservice.service.DetailService;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.AddressMapper;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.DetailMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailManager implements DetailService {

    private final DetailRepository detailRepository;
    private final DetailMapper detailMapper;
    private final AddressService addressService;
    private final AddressMapper addressMapper;

    public DetailManager(DetailRepository detailRepository,
                         DetailMapper detailMapper,
                         AddressService addressService, AddressMapper addressMapper) {
        this.detailRepository = detailRepository;
        this.detailMapper = detailMapper;
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }

    @Override
    public DetailDto create(CreateDetailRequest request) {
        return detailMapper.toDetailDto(detailRepository.save(detailMapper.toDetail(request)));
    }

    @Override
    public void delete(String detailId) {
        detailRepository.deleteById(detailId);
    }

    @Override
    public DetailDto update(UpdateDetailRequest request) {
        return detailMapper.toDetailDto(detailRepository.save(detailMapper.toDetail(request)));
    }

    @Override
    public List<DetailDto> getAll() {
        return detailMapper.toDetailDtoList(detailRepository.findAll());
    }

    @Override
    public DetailDto getById(String detailId) {
        return detailMapper.toDetailDto(detailRepository.findById(detailId)
                .orElseThrow(()-> new DetailNotFoundException("Detail not found by id: "+detailId)));
    }
}
