package com.studentinformationsystem.courseschedulingservice.dto.classroom;

import lombok.Builder;

import java.util.Objects;

@Builder
public class ClassroomDto {
    private String id;
    private String code;
    private int capacity;
    private boolean isThereProjectorAndComputer;

    public ClassroomDto() {
    }

    public ClassroomDto(String id, String code, int capacity, boolean isThereProjectorAndComputer) {
        this.id = id;
        this.code = code;
        this.capacity = capacity;
        this.isThereProjectorAndComputer = isThereProjectorAndComputer;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isThereProjectorAndComputer() {
        return isThereProjectorAndComputer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassroomDto that = (ClassroomDto) o;
        return capacity == that.capacity && isThereProjectorAndComputer == that.isThereProjectorAndComputer && Objects.equals(id, that.id) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, capacity, isThereProjectorAndComputer);
    }

    @Override
    public String toString() {
        return "ClassroomDto{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", capacity=" + capacity +
                ", isThereProjectorAndComputer=" + isThereProjectorAndComputer +
                '}';
    }
}
