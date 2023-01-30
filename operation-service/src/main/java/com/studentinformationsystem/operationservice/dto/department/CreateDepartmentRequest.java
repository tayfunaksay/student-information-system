package com.studentinformationsystem.operationservice.dto.department;

import lombok.Builder;

import java.util.Objects;
@Builder
public class CreateDepartmentRequest {
    private String facultyId;
    private String name;
    private String code;

    public CreateDepartmentRequest() {
    }

    public CreateDepartmentRequest(String facultyId, String name, String code) {
        this.facultyId = facultyId;
        this.name = name;
        this.code = code;
    }

    public String getFacultyId() {
        return facultyId;
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
        CreateDepartmentRequest that = (CreateDepartmentRequest) o;
        return Objects.equals(facultyId, that.facultyId) && Objects.equals(name, that.name) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyId, name, code);
    }

    @Override
    public String toString() {
        return "CreateDepartmentRequest{" +
                "facultyId='" + facultyId + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
