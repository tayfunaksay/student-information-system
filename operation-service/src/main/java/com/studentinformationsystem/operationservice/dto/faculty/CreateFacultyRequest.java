package com.studentinformationsystem.operationservice.dto.faculty;

import lombok.Builder;

import java.util.Objects;

@Builder
public class CreateFacultyRequest {
    private String name;

    public CreateFacultyRequest() {
    }

    public CreateFacultyRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateFacultyRequest request = (CreateFacultyRequest) o;
        return Objects.equals(name, request.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "CreateFacultyRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
