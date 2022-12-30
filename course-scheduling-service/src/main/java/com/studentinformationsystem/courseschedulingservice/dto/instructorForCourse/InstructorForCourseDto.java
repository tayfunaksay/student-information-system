package com.studentinformationsystem.courseschedulingservice.dto.instructorForCourse;

import lombok.Builder;

import java.util.Objects;

@Builder
public class InstructorForCourseDto {
    private String id;
    private String courseName;
    private String instructorName;

    public InstructorForCourseDto() {
    }

    public InstructorForCourseDto(String id, String courseName, String instructorName) {
        this.id = id;
        this.courseName = courseName;
        this.instructorName = instructorName;
    }

    public String getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstructorForCourseDto that = (InstructorForCourseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(courseName, that.courseName) && Objects.equals(instructorName, that.instructorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, instructorName);
    }

    @Override
    public String toString() {
        return "InstructorForCourseDto{" +
                "id='" + id + '\'' +
                ", courseId='" + courseName + '\'' +
                ", instructorId='" + instructorName + '\'' +
                '}';
    }
}
