package com.studentinformationsystem.registrarservice.utility.mapper.concretes;

import com.studentinformationsystem.registrarservice.dto.address.AddressDto;
import com.studentinformationsystem.registrarservice.dto.address.CreateAddressRequest;
import com.studentinformationsystem.registrarservice.dto.address.UpdateAddressRequest;
import com.studentinformationsystem.registrarservice.model.Address;
import com.studentinformationsystem.registrarservice.model.City;
import com.studentinformationsystem.registrarservice.model.District;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.AddressMapper;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.CityMapper;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.DistrictMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressConverter implements AddressMapper {
    private final DistrictMapper districtMapper;
    private final CityMapper cityMapper;

    public AddressConverter(DistrictMapper districtMapper, CityMapper cityMapper) {
        this.districtMapper = districtMapper;
        this.cityMapper = cityMapper;
    }

    @Override
    public AddressDto toAddressDto(Address from) {
        return AddressDto.builder()
                .id(from.getId())
                .cityDto(cityMapper.toCityDto(from.getCity()))
                .districtDto(districtMapper.toDistrictDto(from.getDistrict()))
                .postCode(from.getPostCode())
                .street(from.getStreet())
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
                .city(City.builder()
                        .id(request.getCityId())
                        .build())
                .district(District.builder()
                        .id(request.getDistrictId())
                        .build())
                .addressType(request.getAddressType())
                .postCode(request.getPostCode())
                .street(request.getStreet())
                .build();
    }

    @Override
    public Address toAddress(UpdateAddressRequest request) {
        return Address.builder()
                .id(request.getId())
                .city(City.builder()
                        .id(request.getCityId())
                        .build())
                .district(District.builder()
                        .id(request.getDistrictId())
                        .build())
                .addressType(request.getAddressType())
                .postCode(request.getPostCode())
                .street(request.getStreet())
                .build();
    }
}
