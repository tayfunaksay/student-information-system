package com.studentinformationsystem.courseschedulingservice.dto.offeredCourse;

import lombok.Builder;

import java.util.Objects;

@Builder
public class OfferedCourseDto {
    private String id;
    private String courseName;
    private String departmentName;
    private String semesterName;
    private String instructorName;

    public OfferedCourseDto() {
    }

    public OfferedCourseDto(String id, String courseName, String departmentName, String semesterName, String instructorName) {
        this.id = id;
        this.courseName = courseName;
        this.departmentName = departmentName;
        this.semesterName = semesterName;
        this.instructorName = instructorName;
    }

    public String getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferedCourseDto that = (OfferedCourseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(courseName, that.courseName) && Objects.equals(departmentName, that.departmentName) && Objects.equals(semesterName, that.semesterName) && Objects.equals(instructorName, that.instructorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, departmentName, semesterName, instructorName);
    }

    @Override
    public String toString() {
        return "OfferedCourseDto{" +
                "id='" + id + '\'' +
                ", courseName='" + courseName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", semesterName='" + semesterName + '\'' +
                ", instructorName='" + instructorName + '\'' +
                '}';
    }
}
