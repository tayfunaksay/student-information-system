package com.studentinformationsystem.courseschedulingservice.dto.offeredCourse;

import com.studentinformationsystem.courseschedulingservice.model.enums.Branch;

import java.util.Objects;

public class UpdateOfferedCourseRequest {
    private String id;
    private String courseId;
    private String classroomId;
    private String courseHourId;
    private String semesterId;
    private String departmentId;
    private String instructorId;
    private Branch branch;
    private int capacity;

    public String getId() {
        return id;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getClassroomId() {
        return classroomId;
    }

    public String getCourseHourId() {
        return courseHourId;
    }

    public String getSemesterId() {
        return semesterId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public Branch getBranch() {
        return branch;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateOfferedCourseRequest that = (UpdateOfferedCourseRequest) o;
        return capacity == that.capacity && Objects.equals(id, that.id) && Objects.equals(courseId, that.courseId) && Objects.equals(classroomId, that.classroomId) && Objects.equals(courseHourId, that.courseHourId) && Objects.equals(semesterId, that.semesterId) && Objects.equals(departmentId, that.departmentId) && Objects.equals(instructorId, that.instructorId) && branch == that.branch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, classroomId, courseHourId, semesterId, departmentId, instructorId, branch, capacity);
    }

    @Override
    public String toString() {
        return "UpdateOfferedCourseRequest{" +
                "id='" + id + '\'' +
                ", courseId='" + courseId + '\'' +
                ", classroomId='" + classroomId + '\'' +
                ", courseHourId='" + courseHourId + '\'' +
                ", semesterId='" + semesterId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", instructorId='" + instructorId + '\'' +
                ", branch=" + branch +
                ", capacity=" + capacity +
                '}';
    }
}
