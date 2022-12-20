package com.studentinformationsystem.registrarservice.dto.address;

import com.studentinformationsystem.registrarservice.model.AddressType;
public class CreateAddressRequest {
    private String cityId;
    private String districtId;
    private String postCode;
    private String street;
    private AddressType addressType;


    public String getCityId() {
        return cityId;
    }

    public String getDistrictId() {
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
