package com.studentinformationsystem.courseschedulingservice.dto.offeredCourse;

import com.studentinformationsystem.courseschedulingservice.dto.classroom.ClassroomDto;
import com.studentinformationsystem.courseschedulingservice.dto.courseHour.CourseHourDto;
import com.studentinformationsystem.courseschedulingservice.dto.semester.SemesterDto;
import com.studentinformationsystem.courseschedulingservice.model.enums.Branch;
import lombok.Builder;

import java.util.Objects;

@Builder
public class OfferedCourseDto {
    private String id;
    private String courseName;
    private ClassroomDto classroom;
    private CourseHourDto courseHour;
    private SemesterDto semester;
    private String departmentName;
    private String instructorName;
    private Branch branch;
    private int capacity;

    public OfferedCourseDto() {
    }

    public OfferedCourseDto(String id, String courseName, ClassroomDto classroom, CourseHourDto courseHour, String departmentName, SemesterDto semester, String instructorName, Branch branch, int capacity) {
        this.id = id;
        this.courseName = courseName;
        this.classroom = classroom;
        this.courseHour = courseHour;
        this.departmentName = departmentName;
        this.semester = semester;
        this.instructorName = instructorName;
        this.branch = branch;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public ClassroomDto getClassroom() {
        return classroom;
    }

    public CourseHourDto getCourseHour() {
        return courseHour;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public SemesterDto getSemester() {
        return semester;
    }

    public String getInstructorName() {
        return instructorName;
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
        OfferedCourseDto that = (OfferedCourseDto) o;
        return capacity == that.capacity && Objects.equals(id, that.id) && Objects.equals(courseName, that.courseName) && Objects.equals(classroom, that.classroom) && Objects.equals(courseHour, that.courseHour) && Objects.equals(departmentName, that.departmentName) && Objects.equals(semester, that.semester) && Objects.equals(instructorName, that.instructorName) && branch == that.branch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, classroom, courseHour, departmentName, semester, instructorName, branch, capacity);
    }

    @Override
    public String toString() {
        return "OfferedCourseDto{" +
                "id='" + id + '\'' +
                ", courseName='" + courseName + '\'' +
                ", classroom=" + classroom +
                ", courseHour=" + courseHour +
                ", departmentName='" + departmentName + '\'' +
                ", semester=" + semester +
                ", instructorName='" + instructorName + '\'' +
                ", branch=" + branch +
                ", capacity=" + capacity +
                '}';
    }
}
