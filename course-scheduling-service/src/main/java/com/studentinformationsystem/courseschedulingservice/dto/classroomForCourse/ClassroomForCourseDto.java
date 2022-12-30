package com.studentinformationsystem.courseschedulingservice.dto.classroomForCourse;

import lombok.Builder;

import java.util.Objects;
@Builder
public class ClassroomForCourseDto {
    private String id;
    private String courseName;
    private String classroomName;

    public ClassroomForCourseDto() {
    }

    public ClassroomForCourseDto(String id, String courseName, String classroomName) {
        this.id = id;
        this.courseName = courseName;
        this.classroomName = classroomName;
    }

    public String getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getClassroomName() {
        return classroomName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassroomForCourseDto that = (ClassroomForCourseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(courseName, that.courseName) && Objects.equals(classroomName, that.classroomName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, classroomName);
    }

    @Override
    public String toString() {
        return "ClassroomForCourseDto{" +
                "id='" + id + '\'' +
                ", courseId='" + courseName + '\'' +
                ", classroomId='" + classroomName + '\'' +
                '}';
    }
}
