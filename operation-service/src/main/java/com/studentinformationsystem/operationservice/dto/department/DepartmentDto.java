package com.studentinformationsystem.operationservice.dto.department;

import com.studentinformationsystem.operationservice.dto.faculty.FacultyDto;
import lombok.Builder;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentDto that = (DepartmentDto) o;
        return Objects.equals(id, that.id) && Objects.equals(facultyDto, that.facultyDto) && Objects.equals(name, that.name) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, facultyDto, name, code);
    }

    @Override
    public String toString() {
        return "DepartmentDto{" +
                "id='" + id + '\'' +
                ", facultyDto=" + facultyDto +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
