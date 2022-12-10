package com.studentinformationsystem.registrarservice.dto.city;

public class UpdateCityRequest {

    private String id;
    private String name;

    private short plateNumber;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public short getPlateNumber() {
        return plateNumber;
    }

}
