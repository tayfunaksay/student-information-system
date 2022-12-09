package com.studentinformationsystem.registrarservice.dto.address;

import com.studentinformationsystem.registrarservice.model.AddressType;

public class UpdateAddressRequest {
    private short cityId;
    private long districtId;
    private String postCode;
    private String street;
    private AddressType addressType;

    public short getCityId() {
        return cityId;
    }

    public long getDistrictId() {
        return districtId;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getStreet() {
        return street;
    }

    public AddressType getAddressType() {
        return addressType;
    }
}
