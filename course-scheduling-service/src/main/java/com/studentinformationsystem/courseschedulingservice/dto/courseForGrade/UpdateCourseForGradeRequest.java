package com.studentinformationsystem.courseschedulingservice.dto.courseForGrade;

import java.util.Objects;

public class UpdateCourseForGradeRequest {
    private String id;
    private String gradeId;
    private String courseId;

    public String getId() {
        return id;
    }

    public String getGradeId() {
        return gradeId;
    }

    public String getCourseId() {
        return courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateCourseForGradeRequest that = (UpdateCourseForGradeRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(gradeId, that.gradeId) && Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gradeId, courseId);
    }

    @Override
    public String toString() {
        return "UpdateCourseForGradeRequest{" +
                "id='" + id + '\'' +
                ", gradeId='" + gradeId + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }
}
