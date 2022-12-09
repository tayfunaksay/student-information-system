package com.studentinformationsystem.registrarservice.dto.district;

public class CreateDistrictRequest {

    private String name;
    private short cityId;

    public String getName() {
        return name;
    }

    public short getCityId() {
        return cityId;
    }
}
