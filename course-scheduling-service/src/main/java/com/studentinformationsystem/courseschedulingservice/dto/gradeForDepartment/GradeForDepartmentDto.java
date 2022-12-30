package com.studentinformationsystem.courseschedulingservice.dto.gradeForDepartment;

import lombok.Builder;

import java.util.Objects;

@Builder
public class GradeForDepartmentDto {
    private String id;
    private String departmentName;
    private String gradeName;

    public GradeForDepartmentDto() {
    }

    public GradeForDepartmentDto(String id, String departmentName, String gradeName) {
        this.id = id;
        this.departmentName = departmentName;
        this.gradeName = gradeName;
    }

    public String getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getGradeName() {
        return gradeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradeForDepartmentDto that = (GradeForDepartmentDto) o;
        return Objects.equals(id, that.id) && Objects.equals(departmentName, that.departmentName) && Objects.equals(gradeName, that.gradeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentName, gradeName);
    }

    @Override
    public String toString() {
        return "GradeForDepartmentDto{" +
                "id='" + id + '\'' +
                ", departmentId='" + departmentName + '\'' +
                ", gradeId='" + gradeName + '\'' +
                '}';
    }
}
