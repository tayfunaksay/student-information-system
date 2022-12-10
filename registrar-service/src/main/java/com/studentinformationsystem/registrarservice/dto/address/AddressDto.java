package com.studentinformationsystem.registrarservice.dto.address;

import com.studentinformationsystem.registrarservice.dto.city.CityDto;
import com.studentinformationsystem.registrarservice.dto.district.DistrictDto;
import lombok.Builder;

@Builder
public class AddressDto {

    private String id;
    private CityDto cityDto;

    private DistrictDto districtDto;

    private String postCode;

    private String street;

    public AddressDto() {
    }

    public AddressDto(String id, CityDto cityDto, DistrictDto districtDto, String postCode, String street) {
        this.id = id;
        this.cityDto = cityDto;
        this.districtDto = districtDto;
        this.postCode = postCode;
        this.street = street;
    }
}
