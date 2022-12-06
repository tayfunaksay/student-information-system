package com.studentinformationsystem.registrarservice.dto.city;

import lombok.Builder;

@Builder
public class CityDto {

    private String name;
    private short plateNumber;

    public CityDto() {
    }

    public CityDto(String name, short plateNumber) {
        this.name = name;
        this.plateNumber = plateNumber;
    }
}
