package com.studentinformationsystem.courseregistryservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Builder
@Entity
@Table(name = "student_course_registrations")
public class StudentCourseRegistration {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String studentId;
    private String offeredCourseId;

    public StudentCourseRegistration() {
    }

    public StudentCourseRegistration(String id, String studentId, String offeredCourseId) {
        this.id = id;
        this.studentId = studentId;
        this.offeredCourseId = offeredCourseId;
    }

    public String getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getOfferedCourseId() {
        return offeredCourseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCourseRegistration that = (StudentCourseRegistration) o;
        return Objects.equals(id, that.id) && Objects.equals(studentId, that.studentId) && Objects.equals(offeredCourseId, that.offeredCourseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, offeredCourseId);
    }

    @Override
    public String toString() {
        return "StudentCourseRegistration{" +
                "id='" + id + '\'' +
                ", studentId='" + studentId + '\'' +
                ", offeredCourseId='" + offeredCourseId + '\'' +
                '}';
    }
}
