package com.studentinformationsystem.courseschedulingservice.dto.courseForGrade;

import java.util.Objects;

public class CreateCourseForGradeRequest {
    private String gradeId;
    private String courseId;

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
        CreateCourseForGradeRequest that = (CreateCourseForGradeRequest) o;
        return Objects.equals(gradeId, that.gradeId) && Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradeId, courseId);
    }

    @Override
    public String toString() {
        return "CreateCourseForGradeRequest{" +
                "gradeId='" + gradeId + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }
}
