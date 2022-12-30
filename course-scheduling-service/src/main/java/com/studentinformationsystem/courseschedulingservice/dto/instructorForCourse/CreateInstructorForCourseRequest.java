package com.studentinformationsystem.courseschedulingservice.dto.instructorForCourse;

import java.util.Objects;

public class CreateInstructorForCourseRequest {
    private String courseId;
    private String instructorId;

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
        CreateInstructorForCourseRequest that = (CreateInstructorForCourseRequest) o;
        return Objects.equals(courseId, that.courseId) && Objects.equals(instructorId, that.instructorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, instructorId);
    }

    @Override
    public String toString() {
        return "CreateInstructorForCourseRequest{" +
                "courseId='" + courseId + '\'' +
                ", instructorId='" + instructorId + '\'' +
                '}';
    }
}
