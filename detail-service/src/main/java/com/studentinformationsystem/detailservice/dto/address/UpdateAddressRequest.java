package com.studentinformationsystem.detailservice.dto.address;

import com.studentinformationsystem.detailservice.model.AddressType;
import lombok.Builder;
import java.util.Objects;
@Builder
public class UpdateAddressRequest {
    private String id;
    private String cityId;
    private String districtId;
    private String street;
    private AddressType addressType;

    public UpdateAddressRequest() {
    }

    public UpdateAddressRequest(String id, String cityId, String districtId, String street, AddressType addressType) {
        this.id = id;
        this.cityId = cityId;
        this.districtId = districtId;
        this.street = street;
        this.addressType = addressType;
    }

    public String getId() {
        return id;
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
        UpdateAddressRequest that = (UpdateAddressRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(cityId, that.cityId) && Objects.equals(districtId, that.districtId) && Objects.equals(street, that.street) && addressType == that.addressType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cityId, districtId, street, addressType);
    }

    @Override
    public String toString() {
        return "UpdateAddressRequest{" +
                "id='" + id + '\'' +
                ", cityId='" + cityId + '\'' +
                ", districtId='" + districtId + '\'' +
                ", street='" + street + '\'' +
                ", addressType=" + addressType +
                '}';
    }
}
