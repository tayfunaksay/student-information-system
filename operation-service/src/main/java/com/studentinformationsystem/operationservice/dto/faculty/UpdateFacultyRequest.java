package com.studentinformationsystem.operationservice.dto.faculty;

import lombok.Builder;

import java.util.Objects;

@Builder
public class UpdateFacultyRequest {
    private String id;
    private String name;

    public UpdateFacultyRequest() {
    }

    public UpdateFacultyRequest(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateFacultyRequest that = (UpdateFacultyRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "UpdateFacultyRequest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
