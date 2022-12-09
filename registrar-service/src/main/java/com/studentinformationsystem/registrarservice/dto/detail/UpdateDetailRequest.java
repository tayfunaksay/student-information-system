package com.studentinformationsystem.registrarservice.dto.detail;

import com.studentinformationsystem.registrarservice.dto.address.UpdateAddressRequest;

import java.util.List;

public class UpdateDetailRequest {

    private List<UpdateAddressRequest> addresses;
    private String nationalIdentity;
    private String gender;

    public List<UpdateAddressRequest> getAddresses() {
        return addresses;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public String getGender() {
        return gender;
    }
}
