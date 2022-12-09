package com.studentinformationsystem.registrarservice.dto.district;

import lombok.Builder;

@Builder
public class DistrictDto {
    private String name;

    public DistrictDto() {
    }

    public DistrictDto(String name) {
        this.name = name;
    }
}
