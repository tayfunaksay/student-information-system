package com.studentinformationsystem.registrarservice.dto.address;

public class CreateAddressRequest {

    private long detailId;
    private short cityId;
    private long districtId;
    private String postCode;
    private String street;

    public long getDetailId() {
        return detailId;
    }

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
