package com.studentinformationsystem.detailservice.utility;

import com.studentinformationsystem.detailservice.dto.detail.CreateDetailRequest;
import com.studentinformationsystem.detailservice.dto.detail.DetailDto;
import com.studentinformationsystem.detailservice.dto.detail.UpdateDetailRequest;
import com.studentinformationsystem.detailservice.model.Detail;
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
                .homeAddress(addressMapper.toAddress(request.getHomeAddress()))
                .workAddress(addressMapper.toAddress(request.getWorkAddress()))
                .build();
    }

    @Override
    public Detail toDetail(UpdateDetailRequest request) {
        return Detail.builder()
                .id(request.getId())
                .homeAddress(addressMapper.toAddress(request.getHomeAddress()))
                .workAddress(addressMapper.toAddress(request.getWorkAddress()))
                .build();
    }
}
