package com.studentinformationsystem.registrarservice.dto.city;

import lombok.Builder;

@Builder
public class CityDto {

    private String id;
    private String name;
    private short plateNumber;

    public CityDto() {
    }

    public CityDto(String id, String name, short plateNumber) {
        this.id = id;
        this.name = name;
        this.plateNumber = plateNumber;
    }
}
