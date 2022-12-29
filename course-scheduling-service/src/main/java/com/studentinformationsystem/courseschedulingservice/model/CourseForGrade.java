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
@Table(name = "courses_for_grades")
public class CourseForGrade {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String gradeId;
    private String courseId;

    public CourseForGrade() {
    }

    public CourseForGrade(String id, String courseId, String gradeId) {
        this.id = id;
        this.courseId = courseId;
        this.gradeId = gradeId;
    }

    public String getId() {
        return id;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getGradeId() {
        return gradeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseForGrade that = (CourseForGrade) o;
        return Objects.equals(id, that.id) && Objects.equals(courseId, that.courseId) && Objects.equals(gradeId, that.gradeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, gradeId);
    }

    @Override
    public String toString() {
        return "CourseForGrade{" +
                "id='" + id + '\'' +
                ", courseId='" + courseId + '\'' +
                ", gradeId='" + gradeId + '\'' +
                '}';
    }

}
