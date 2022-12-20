package com.studentinformationsystem.registrarservice.dto.faculty;

import lombok.Builder;

@Builder
public class FacultyDto {
    private String id;
    private String name;

    public FacultyDto() {
    }

    public FacultyDto(String id, String name) {
        this.id=id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
