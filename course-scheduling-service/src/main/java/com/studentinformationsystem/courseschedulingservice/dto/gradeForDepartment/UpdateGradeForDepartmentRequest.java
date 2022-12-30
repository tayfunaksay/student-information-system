package com.studentinformationsystem.courseschedulingservice.dto.gradeForDepartment;

import java.util.Objects;

public class UpdateGradeForDepartmentRequest {
    private String id;
    private String departmentId;
    private String gradeId;

    public String getId() {
        return id;
    }

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
        UpdateGradeForDepartmentRequest that = (UpdateGradeForDepartmentRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(departmentId, that.departmentId) && Objects.equals(gradeId, that.gradeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentId, gradeId);
    }

    @Override
    public String toString() {
        return "UpdateGradeForDepartmentRequest{" +
                "id='" + id + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", gradeId='" + gradeId + '\'' +
                '}';
    }
}
