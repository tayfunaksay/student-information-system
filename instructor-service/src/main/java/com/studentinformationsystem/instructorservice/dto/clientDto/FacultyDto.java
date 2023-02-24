package com.studentinformationsystem.instructorservice.dto.clientDto;

import lombok.Builder;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyDto that = (FacultyDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "FacultyDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
