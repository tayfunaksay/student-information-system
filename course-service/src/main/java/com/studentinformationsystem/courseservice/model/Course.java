package com.studentinformationsystem.courseservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Builder
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String originalName;
    private String turkishName;
    private String code;
    private double courseCredit;
    private short courseAKTS;
    private short theoreticalLessonHour;
    private short practicalLessonHour;
    private CourseType courseType;
    private SemesterType semesterType;
    private String departmentId;
    private boolean isNeedProjectorAndComputer;
    private boolean isTherePreCourse;

    public Course() {
    }

    public Course(String id, String originalName, String turkishName, String code, double courseCredit, short courseAKTS, short theoreticalLessonHour, short practicalLessonHour, CourseType courseType, SemesterType semesterType, String departmentId, boolean isNeedProjectorAndComputer, boolean isTherePreCourse) {
        this.id = id;
        this.originalName = originalName;
        this.turkishName = turkishName;
        this.code = code;
        this.courseCredit = courseCredit;
        this.courseAKTS = courseAKTS;
        this.theoreticalLessonHour = theoreticalLessonHour;
        this.practicalLessonHour = practicalLessonHour;
        this.courseType = courseType;
        this.semesterType = semesterType;
        this.departmentId = departmentId;
        this.isNeedProjectorAndComputer = isNeedProjectorAndComputer;
        this.isTherePreCourse = isTherePreCourse;
    }

    public String getId() {
        return id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getTurkishName() {
        return turkishName;
    }

    public String getCode() {
        return code;
    }

    public double getCourseCredit() {
        return courseCredit;
    }

    public short getCourseAKTS() {
        return courseAKTS;
    }

    public short getTheoreticalLessonHour() {
        return theoreticalLessonHour;
    }

    public short getPracticalLessonHour() {
        return practicalLessonHour;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public SemesterType getSemesterType() {
        return semesterType;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public boolean isNeedProjectorAndComputer() {
        return isNeedProjectorAndComputer;
    }

    public boolean isTherePreCourse() {
        return isTherePreCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Double.compare(course.courseCredit, courseCredit) == 0 && courseAKTS == course.courseAKTS && theoreticalLessonHour == course.theoreticalLessonHour && practicalLessonHour == course.practicalLessonHour && isNeedProjectorAndComputer == course.isNeedProjectorAndComputer && isTherePreCourse == course.isTherePreCourse && Objects.equals(id, course.id) && Objects.equals(originalName, course.originalName) && Objects.equals(turkishName, course.turkishName) && Objects.equals(code, course.code) && courseType == course.courseType && semesterType == course.semesterType && Objects.equals(departmentId, course.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, originalName, turkishName, code, courseCredit, courseAKTS, theoreticalLessonHour, practicalLessonHour, courseType, semesterType, departmentId, isNeedProjectorAndComputer, isTherePreCourse);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", originalName='" + originalName + '\'' +
                ", turkishName='" + turkishName + '\'' +
                ", code='" + code + '\'' +
                ", courseCredit=" + courseCredit +
                ", courseAKTS=" + courseAKTS +
                ", theoreticalLessonHour=" + theoreticalLessonHour +
                ", practicalLessonHour=" + practicalLessonHour +
                ", courseType=" + courseType +
                ", semesterType=" + semesterType +
                ", departmentId='" + departmentId + '\'' +
                ", isNeedProjectorAndComputer=" + isNeedProjectorAndComputer +
                ", isTherePreCourse=" + isTherePreCourse +
                '}';
    }
}
