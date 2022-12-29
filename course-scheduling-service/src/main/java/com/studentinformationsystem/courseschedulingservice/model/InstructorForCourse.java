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
@Table(name = "instructors_for_courses")
public class InstructorForCourse {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String courseId;
    private String instructorId;

    public InstructorForCourse() {
    }

    public InstructorForCourse(String id, String courseId, String instructorId) {
        this.id = id;
        this.courseId = courseId;
        this.instructorId = instructorId;
    }

    public String getId() {
        return id;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getInstructorId() {
        return instructorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstructorForCourse that = (InstructorForCourse) o;
        return Objects.equals(id, that.id) && Objects.equals(courseId, that.courseId) && Objects.equals(instructorId, that.instructorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, instructorId);
    }

    @Override
    public String toString() {
        return "InstructorForCourse{" +
                "id='" + id + '\'' +
                ", courseId='" + courseId + '\'' +
                ", instructorId='" + instructorId + '\'' +
                '}';
    }
}
