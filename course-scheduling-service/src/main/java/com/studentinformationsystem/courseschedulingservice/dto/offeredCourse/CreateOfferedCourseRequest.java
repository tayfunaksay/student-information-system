package com.studentinformationsystem.courseschedulingservice.dto.offeredCourse;

import java.util.Objects;

public class CreateOfferedCourseRequest {
    private String courseName;
    private String departmentName;
    private String semesterName;
    private String instructorName;

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
        CreateOfferedCourseRequest that = (CreateOfferedCourseRequest) o;
        return Objects.equals(courseName, that.courseName) && Objects.equals(departmentName, that.departmentName) && Objects.equals(semesterName, that.semesterName) && Objects.equals(instructorName, that.instructorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, departmentName, semesterName, instructorName);
    }

    @Override
    public String toString() {
        return "CreateOfferedCourseRequest{" +
                "courseName='" + courseName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", semesterName='" + semesterName + '\'' +
                ", instructorName='" + instructorName + '\'' +
                '}';
    }
}
