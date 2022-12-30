package com.studentinformationsystem.courseschedulingservice.dto.instructorForCourse;

import java.util.Objects;

public class UpdateInstructorForCourseRequest {
    private String id;
    private String courseId;
    private String instructorId;

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
        UpdateInstructorForCourseRequest that = (UpdateInstructorForCourseRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(courseId, that.courseId) && Objects.equals(instructorId, that.instructorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, instructorId);
    }

    @Override
    public String toString() {
        return "UpdateInstructorForCourseRequest{" +
                "id='" + id + '\'' +
                ", courseId='" + courseId + '\'' +
                ", instructorId='" + instructorId + '\'' +
                '}';
    }
}
