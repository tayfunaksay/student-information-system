package com.studentinformationsystem.registrarservice.dto.detail;

import com.studentinformationsystem.registrarservice.dto.address.CreateAddressRequest;
public class CreateDetailRequest {
    private CreateAddressRequest homeAddress;
    private CreateAddressRequest workAddress;
    private String nationalIdentity;
    private String gender;

    public CreateAddressRequest getHomeAddress() {
        return homeAddress;
    }

    public CreateAddressRequest getWorkAddress() {
        return workAddress;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public String getGender() {
        return gender;
    }

}
