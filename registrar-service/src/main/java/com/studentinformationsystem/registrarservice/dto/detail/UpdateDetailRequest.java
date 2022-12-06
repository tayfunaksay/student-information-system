package com.studentinformationsystem.registrarservice.dto.detail;

import com.studentinformationsystem.registrarservice.dto.address.CreateAddressRequest;

import java.util.List;

public class UpdateDetailRequest {

    private List<CreateAddressRequest> addresses;
    private String nationalIdentity;
    private String gender;

    public List<CreateAddressRequest> getAddresses() {
        return addresses;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public String getGender() {
        return gender;
    }
}
