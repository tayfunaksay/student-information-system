package com.studentinformationsystem.registrarservice.dto.detail;

import com.studentinformationsystem.registrarservice.dto.address.UpdateAddressRequest;

public class UpdateDetailRequest {
    private String id;
    private UpdateAddressRequest homeAddress;
    private UpdateAddressRequest workAddress;
    private String nationalIdentity;
    private String gender;

    public String getId() {
        return id;
    }

    public UpdateAddressRequest getHomeAddress() {
        return homeAddress;
    }

    public UpdateAddressRequest getWorkAddress() {
        return workAddress;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public String getGender() {
        return gender;
    }
}
