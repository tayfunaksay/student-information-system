package com.studentinformationsystem.courseschedulingservice.dto.classroomForCourse;

import java.util.Objects;

public class CreateClassroomForCourseRequest {
    private String courseId;
    private String classroomId;

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
        CreateClassroomForCourseRequest that = (CreateClassroomForCourseRequest) o;
        return Objects.equals(courseId, that.courseId) && Objects.equals(classroomId, that.classroomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, classroomId);
    }

    @Override
    public String toString() {
        return "CreateClassroomForCourseRequest{" +
                "courseId='" + courseId + '\'' +
                ", classroomId='" + classroomId + '\'' +
                '}';
    }
}
