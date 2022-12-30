package com.studentinformationsystem.operationservice.dto.classroom;

import java.util.Objects;

public class UpdateClassroomRequest {
    private String id;
    private String code;
    private int capacity;
    private boolean isThereProjectorAndComputer;

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
        UpdateClassroomRequest that = (UpdateClassroomRequest) o;
        return capacity == that.capacity && isThereProjectorAndComputer == that.isThereProjectorAndComputer && Objects.equals(id, that.id) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, capacity, isThereProjectorAndComputer);
    }

    @Override
    public String toString() {
        return "UpdateClassroomRequest{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", capacity=" + capacity +
                ", isThereProjectorAndComputer=" + isThereProjectorAndComputer +
                '}';
    }
}
