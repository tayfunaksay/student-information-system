package com.studentinformationsystem.courseschedulingservice.dto.courseForGrade;

import lombok.Builder;

import java.util.Objects;

@Builder
public class CourseForGradeDto {
    private String id;
    private String gradeName;
    private String courseName;

    public CourseForGradeDto() {
    }

    public CourseForGradeDto(String id, String gradeName, String courseName) {
        this.id = id;
        this.gradeName = gradeName;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseForGradeDto that = (CourseForGradeDto) o;
        return Objects.equals(id, that.id) && Objects.equals(gradeName, that.gradeName) && Objects.equals(courseName, that.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gradeName, courseName);
    }

    @Override
    public String toString() {
        return "CourseForGradeDto{" +
                "id='" + id + '\'' +
                ", gradeId='" + gradeName + '\'' +
                ", courseId='" + courseName + '\'' +
                '}';
    }
}
