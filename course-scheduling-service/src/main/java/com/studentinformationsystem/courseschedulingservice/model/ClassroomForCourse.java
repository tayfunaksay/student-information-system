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
@Table(name = "classrooms_for_courses")
public class ClassroomForCourse {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String courseId;
    private String classroomId;

    public ClassroomForCourse() {
    }

    public ClassroomForCourse(String id, String courseId, String classroomId) {
        this.id = id;
        this.courseId = courseId;
        this.classroomId = classroomId;
    }

    public String getId() {
        return id;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getClassroomId() {
        return classroomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassroomForCourse that = (ClassroomForCourse) o;
        return Objects.equals(courseId, that.courseId) && Objects.equals(classroomId, that.classroomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, classroomId);
    }

    @Override
    public String toString() {
        return "ClassroomForCourse{" +
                "courseId='" + courseId + '\'' +
                ", classroomId='" + classroomId + '\'' +
                '}';
    }
}
