package com.studentinformationsystem.courseschedulingservice.dto.classroomForCourse;

import java.util.Objects;

public class UpdateClassroomForCourseRequest {
    private String id;
    private String courseId;
    private String classroomId;

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
        UpdateClassroomForCourseRequest that = (UpdateClassroomForCourseRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(courseId, that.courseId) && Objects.equals(classroomId, that.classroomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, classroomId);
    }

    @Override
    public String toString() {
        return "UpdateClassroomForCourseRequest{" +
                "id='" + id + '\'' +
                ", courseId='" + courseId + '\'' +
                ", classroomId='" + classroomId + '\'' +
                '}';
    }
}
