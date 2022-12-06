package com.studentinformationsystem.registrarservice.dto.faculty;

import lombok.Builder;

@Builder
public class FacultyDto {

    private String name;

    public FacultyDto() {
    }

    public FacultyDto(String name) {
        this.name = name;
    }

}
