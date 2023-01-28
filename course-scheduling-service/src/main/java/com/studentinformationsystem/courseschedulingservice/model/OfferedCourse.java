package com.studentinformationsystem.courseschedulingservice.model;

import com.studentinformationsystem.courseschedulingservice.model.enums.Branch;
import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Builder
@Entity
@Table(name = "offered_courses")
public class OfferedCourse {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_hour_id")
    private CourseHour courseHour;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "semester_id")
    private Semester semester;
    private String departmentId;
    private String instructorId;
    private Branch branch;
    private int capacity;

    public OfferedCourse() {
    }

    public OfferedCourse(String id, Course course, Classroom classroom, CourseHour courseHour, Semester semester, String departmentId, String instructorId, Branch branch, int capacity) {
        this.id = id;
        this.course = course;
        this.classroom = classroom;
        this.courseHour = courseHour;
        this.semester = semester;
        this.departmentId = departmentId;
        this.instructorId = instructorId;
        this.branch = branch;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public CourseHour getCourseHour() {
        return courseHour;
    }

    public Semester getSemester() {
        return semester;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public Branch getBranch() {
        return branch;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferedCourse that = (OfferedCourse) o;
        return capacity == that.capacity && Objects.equals(id, that.id) && Objects.equals(course, that.course) && Objects.equals(classroom, that.classroom) && Objects.equals(courseHour, that.courseHour) && Objects.equals(semester, that.semester) && Objects.equals(departmentId, that.departmentId) && Objects.equals(instructorId, that.instructorId) && branch == that.branch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, course, classroom, courseHour, semester, departmentId, instructorId, branch, capacity);
    }

    @Override
    public String toString() {
        return "OfferedCourse{" +
                "id='" + id + '\'' +
                ", course=" + course +
                ", classroom=" + classroom +
                ", courseHour=" + courseHour +
                ", semester=" + semester +
                ", departmentId='" + departmentId + '\'' +
                ", instructorId='" + instructorId + '\'' +
                ", branch=" + branch +
                ", capacity=" + capacity +
                '}';
    }
}
