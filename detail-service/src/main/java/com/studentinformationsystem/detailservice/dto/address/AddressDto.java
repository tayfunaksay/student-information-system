package com.studentinformationsystem.detailservice.dto.address;

import com.studentinformationsystem.detailservice.dto.city.CityDto;
import com.studentinformationsystem.detailservice.dto.district.DistrictDto;
import lombok.Builder;

import java.util.Objects;

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

    public String getId() {
        return id;
    }

    public CityDto getCityDto() {
        return cityDto;
    }

    public DistrictDto getDistrictDto() {
        return districtDto;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto that = (AddressDto) o;
        return Objects.equals(id, that.id) && Objects.equals(cityDto, that.cityDto) && Objects.equals(districtDto, that.districtDto) && Objects.equals(postCode, that.postCode) && Objects.equals(street, that.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityDto, districtDto, postCode, street);
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "id='" + id + '\'' +
                ", cityDto=" + cityDto +
                ", districtDto=" + districtDto +
                ", postCode='" + postCode + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
