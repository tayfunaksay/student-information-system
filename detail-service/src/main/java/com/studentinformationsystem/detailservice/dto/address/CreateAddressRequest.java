package com.studentinformationsystem.detailservice.dto.address;

import com.studentinformationsystem.detailservice.model.AddressType;
import lombok.Builder;

import java.util.Objects;

@Builder
public class CreateAddressRequest {
    private String cityId;
    private String districtId;
    private String street;
    private AddressType addressType;

    public CreateAddressRequest() {
    }

    public CreateAddressRequest(String cityId, String districtId, String street, AddressType addressType) {
        this.cityId = cityId;
        this.districtId = districtId;
        this.street = street;
        this.addressType = addressType;
    }

    public String getCityId() {
        return cityId;
    }

    public String getDistrictId() {
        return districtId;
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
        CreateAddressRequest request = (CreateAddressRequest) o;
        return Objects.equals(cityId, request.cityId) && Objects.equals(districtId, request.districtId) && Objects.equals(street, request.street) && addressType == request.addressType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, districtId, street, addressType);
    }

    @Override
    public String toString() {
        return "CreateAddressRequest{" +
                "cityId='" + cityId + '\'' +
                ", districtId='" + districtId + '\'' +
                ", street='" + street + '\'' +
                ", addressType=" + addressType +
                '}';
    }
}
