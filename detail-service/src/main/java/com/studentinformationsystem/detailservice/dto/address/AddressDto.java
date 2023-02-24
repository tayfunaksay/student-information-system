package com.studentinformationsystem.detailservice.dto.address;

import com.studentinformationsystem.detailservice.dto.city.CityDto;
import com.studentinformationsystem.detailservice.dto.district.DistrictDto;
import com.studentinformationsystem.detailservice.model.AddressType;
import lombok.Builder;

import java.util.Objects;

@Builder
public class AddressDto {
    private String id;
    private CityDto cityDto;
    private DistrictDto districtDto;
    private String street;
    private AddressType addressType;

    public AddressDto() {
    }

    public AddressDto(String id, CityDto cityDto, DistrictDto districtDto, String street, AddressType addressType) {
        this.id = id;
        this.cityDto = cityDto;
        this.districtDto = districtDto;
        this.street = street;
        this.addressType = addressType;
    }

    public String getId() {
        return id;
    }

    public CityDto getCityDto() {
        return cityDto;
    }

    public DistrictDto getDistrictDto() {
        return districtDto;
    }

    public String getStreet() {
        return street;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto that = (AddressDto) o;
        return Objects.equals(id, that.id) && Objects.equals(cityDto, that.cityDto) && Objects.equals(districtDto, that.districtDto) && Objects.equals(street, that.street) && addressType == that.addressType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityDto, districtDto, street, addressType);
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "id='" + id + '\'' +
                ", cityDto=" + cityDto +
                ", districtDto=" + districtDto +
                ", street='" + street + '\'' +
                ", addressType=" + addressType +
                '}';
    }
}
