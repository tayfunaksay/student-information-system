package com.studentinformationsystem.detailservice.utility;

import com.studentinformationsystem.detailservice.dto.detail.CreateDefaultDetailRequest;
import com.studentinformationsystem.detailservice.dto.detail.DetailDto;
import com.studentinformationsystem.detailservice.dto.detail.UpdateDetailRequest;
import com.studentinformationsystem.detailservice.model.*;
import org.springframework.stereotype.Component;

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
    public Detail toDefaultDetail(CreateDefaultDetailRequest request) {
        return Detail.builder()
                .homeAddress(Address.builder()
                        .addressType(AddressType.HOME)
                        .city(City.builder()
                                .id(request.getCityId())
                                .build())
                        .district(District.builder()
                                .id(request.getDistrictId())
                                .build())
                        .build())
                .workAddress(Address.builder()
                        .addressType(AddressType.WORK)
                        .city(City.builder()
                                .id(request.getCityId())
                                .build())
                        .district(District.builder()
                                .id(request.getDistrictId())
                                .build())
                        .build())
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
