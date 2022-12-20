package com.studentinformationsystem.registrarservice.dto.department;

import com.studentinformationsystem.registrarservice.dto.faculty.FacultyDto;
import lombok.Builder;

@Builder
public class DepartmentDto {
    private String id;
    private FacultyDto facultyDto;
    private String name;
    private String code;

    public DepartmentDto() {
    }

    public DepartmentDto(String id,FacultyDto facultyDto, String name, String code) {
        this.id=id;
        this.facultyDto = facultyDto;
        this.name = name;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public FacultyDto getFacultyDto() {
        return facultyDto;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
