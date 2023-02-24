package com.studentinformationsystem.detailservice.utility;

import com.studentinformationsystem.detailservice.dto.address.AddressDto;
import com.studentinformationsystem.detailservice.dto.address.CreateAddressRequest;
import com.studentinformationsystem.detailservice.dto.address.UpdateAddressRequest;
import com.studentinformationsystem.detailservice.model.Address;
import com.studentinformationsystem.detailservice.model.City;
import com.studentinformationsystem.detailservice.model.District;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressConverter implements AddressMapper {
    private final CityMapper cityMapper;
    private final DistrictMapper districtMapper;

    public AddressConverter(CityMapper cityMapper, DistrictMapper districtMapper) {
        this.cityMapper = cityMapper;
        this.districtMapper = districtMapper;
    }

    @Override
    public AddressDto toAddressDto(Address from) {
        return AddressDto.builder()
                .id(from.getId())
                .cityDto(cityMapper.toCityDto(from.getCity()))
                .districtDto(districtMapper.toDistrictDto(from.getDistrict()))
                .street(from.getStreet())
                .addressType(from.getAddressType())
                .build();
    }

    @Override
    public List<AddressDto> toAddressDtoList(List<Address> from) {
        return from.stream()
                .map(address -> toAddressDto(address))
                .collect(Collectors.toList());
    }

    @Override
    public Address toAddress(CreateAddressRequest request) {
        return Address.builder()
                .district(District.builder().id(request.getDistrictId()).build())
                .city(City.builder().id(request.getCityId()).build())
                .street(request.getStreet())
                .addressType(request.getAddressType())
                .build();
    }

    @Override
    public Address toAddress(UpdateAddressRequest request) {
        return Address.builder()
                .id(request.getId())
                .district(District.builder().id(request.getDistrictId()).build())
                .city(City.builder().id(request.getCityId()).build())
                .street(request.getStreet())
                .addressType(request.getAddressType())
                .build();
    }
}
