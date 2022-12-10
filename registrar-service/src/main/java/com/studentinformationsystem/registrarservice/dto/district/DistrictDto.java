package com.studentinformationsystem.registrarservice.dto.district;

import lombok.Builder;

@Builder
public class DistrictDto {
    private String id;
    private String name;

    public DistrictDto() {
    }

    public DistrictDto(String id,String name) {
        this.id=id;
        this.name = name;
    }
}
