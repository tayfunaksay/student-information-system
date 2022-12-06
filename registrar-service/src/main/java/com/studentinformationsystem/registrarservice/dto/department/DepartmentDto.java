package com.studentinformationsystem.registrarservice.dto.department;

import com.studentinformationsystem.registrarservice.dto.faculty.FacultyDto;
import lombok.Builder;

@Builder
public class DepartmentDto {
    private FacultyDto facultyDto;
    private String name;
    private String code;

    public DepartmentDto() {
    }

    public DepartmentDto(FacultyDto facultyDto, String name, String code) {
        this.facultyDto = facultyDto;
        this.name = name;
        this.code = code;
    }
}
