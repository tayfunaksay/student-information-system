package com.studentinformationsystem.operationservice.dto.department;

import lombok.Builder;

import java.util.Objects;
@Builder
public class UpdateDepartmentRequest {
    private String id;
    private String facultyId;
    private String name;
    private String code;

    public UpdateDepartmentRequest() {
    }

    public UpdateDepartmentRequest(String id, String facultyId, String name, String code) {
        this.id = id;
        this.facultyId = facultyId;
        this.name = name;
        this.code = code;
    }

    public String getId() {
        return id;
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
        UpdateDepartmentRequest that = (UpdateDepartmentRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(facultyId, that.facultyId) && Objects.equals(name, that.name) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, facultyId, name, code);
    }

    @Override
    public String toString() {
        return "UpdateDepartmentRequest{" +
                "id='" + id + '\'' +
                ", facultyId='" + facultyId + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
