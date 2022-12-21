package com.studentinformationsystem.registrarservice.utility.mapper.concretes;

import com.studentinformationsystem.registrarservice.dto.detail.CreateDetailRequest;
import com.studentinformationsystem.registrarservice.dto.detail.DetailDto;
import com.studentinformationsystem.registrarservice.dto.detail.UpdateDetailRequest;
import com.studentinformationsystem.registrarservice.model.Detail;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.AddressMapper;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.DetailMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DetailConverter implements DetailMapper {
    private final AddressMapper addressMapper;

    public DetailConverter(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    @Override
    public DetailDto toDetailDto(Detail from) {
        return DetailDto.builder()
                .id(from.getId())
                .nationalIdentity(from.getNationalIdentity())
                .gender(from.getGender())
                .homeAddress(addressMapper.toAddressDto(from.getHomeAddress()))
                .workAddress(addressMapper.toAddressDto(from.getWorkAddress()))
                .build();
    }

    @Override
    public List<DetailDto> toDetailDtoList(List<Detail> from) {
        return from.stream()
                .map(detail -> toDetailDto(detail))
                .collect(Collectors.toList());
    }

    @Override
    public Detail toDetail(CreateDetailRequest request) {
        return Detail.builder()
                .nationalIdentity(request.getNationalIdentity())
                .gender(request.getGender())
                .homeAddress(addressMapper.toAddress(request.getHomeAddress()))
                .workAddress(addressMapper.toAddress(request.getWorkAddress()))
                .build();
    }

    @Override
    public Detail toDetail(UpdateDetailRequest request) {
        return Detail.builder()
                .id(request.getId())
                .nationalIdentity(request.getNationalIdentity())
                .gender(request.getGender())
                .homeAddress(addressMapper.toAddress(request.getHomeAddress()))
                .workAddress(addressMapper.toAddress(request.getWorkAddress()))
                .build();
    }
}
