package com.studentinformationsystem.courseschedulingservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Builder
@Entity
@Table(name = "grades_for_departments")
public class GradeForDepartment {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String departmentId;
    private String gradeId;

    public GradeForDepartment() {
    }

    public GradeForDepartment(String id, String departmentId, String gradeId) {
        this.id = id;
        this.departmentId = departmentId;
        this.gradeId = gradeId;
    }

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
        GradeForDepartment that = (GradeForDepartment) o;
        return Objects.equals(id, that.id) && Objects.equals(departmentId, that.departmentId) && Objects.equals(gradeId, that.gradeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentId, gradeId);
    }

    @Override
    public String toString() {
        return "GradeForDepartment{" +
                "id='" + id + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", gradeId='" + gradeId + '\'' +
                '}';
    }
}
