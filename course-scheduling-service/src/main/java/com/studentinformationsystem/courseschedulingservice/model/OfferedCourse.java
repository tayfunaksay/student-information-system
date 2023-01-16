package com.studentinformationsystem.courseschedulingservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Builder
@Entity
@Table(name = "classrooms")
public class OfferedCourse {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String courseId;
    private String departmentId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "semester_id")
    private Semester semester;
    private String instructorId;

    public OfferedCourse() {

    }

    public OfferedCourse(String id, String courseId, String departmentId, Semester semester, String instructorId) {
        this.id = id;
        this.courseId = courseId;
        this.departmentId = departmentId;
        this.semester = semester;
        this.instructorId = instructorId;
    }

    public String getId() {
        return id;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public Semester getSemester() {
        return semester;
    }

    public String getInstructorId() {
        return instructorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferedCourse that = (OfferedCourse) o;
        return Objects.equals(id, that.id) && Objects.equals(courseId, that.courseId) && Objects.equals(departmentId, that.departmentId) && Objects.equals(semester, that.semester) && Objects.equals(instructorId, that.instructorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, departmentId, semester, instructorId);
    }

    @Override
    public String toString() {
        return "OfferedCourse{" +
                "id='" + id + '\'' +
                ", courseId='" + courseId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", semester=" + semester +
                ", instructorId='" + instructorId + '\'' +
                '}';
    }
}
