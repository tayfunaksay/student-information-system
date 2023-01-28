package com.studentinformationsystem.courseschedulingservice.dto.classroom;

import java.util.Objects;

public class CreateClassroomRequest {
    private String departmentId;
    private String code;
    private int capacity;
    private boolean isThereProjectorAndComputer;

    public String getDepartmentId() {
        return departmentId;
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
        CreateClassroomRequest that = (CreateClassroomRequest) o;
        return capacity == that.capacity && isThereProjectorAndComputer == that.isThereProjectorAndComputer && Objects.equals(departmentId, that.departmentId) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, code, capacity, isThereProjectorAndComputer);
    }

    @Override
    public String toString() {
        return "CreateClassroomRequest{" +
                "departmentId='" + departmentId + '\'' +
                ", code='" + code + '\'' +
                ", capacity=" + capacity +
                ", isThereProjectorAndComputer=" + isThereProjectorAndComputer +
                '}';
    }
}
