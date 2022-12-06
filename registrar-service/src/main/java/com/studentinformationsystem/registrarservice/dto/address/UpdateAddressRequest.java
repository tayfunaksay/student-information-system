package com.studentinformationsystem.registrarservice.dto.address;

public class UpdateAddressRequest {
    private short cityId;
    private long districtId;
    private String postCode;
    private String street;

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
}
