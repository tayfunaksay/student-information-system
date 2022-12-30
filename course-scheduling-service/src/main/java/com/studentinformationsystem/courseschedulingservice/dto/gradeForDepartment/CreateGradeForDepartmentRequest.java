package com.studentinformationsystem.courseschedulingservice.dto.gradeForDepartment;

import java.util.Objects;

public class CreateGradeForDepartmentRequest {
    private String departmentId;
    private String gradeId;

    public String getDepartmentId() {
        return departmentId;
    }

    public String getGradeId() {
        return gradeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateGradeForDepartmentRequest that = (CreateGradeForDepartmentRequest) o;
        return Objects.equals(departmentId, that.departmentId) && Objects.equals(gradeId, that.gradeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, gradeId);
    }

    @Override
    public String toString() {
        return "CreateGradeForDepartmentRequest{" +
                "departmentId='" + departmentId + '\'' +
                ", gradeId='" + gradeId + '\'' +
                '}';
    }
}
