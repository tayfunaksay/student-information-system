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
    private String departmentId;
    private boolean isNeedProjectorAndComputer;
    private boolean isTherePreCourse;

    public Course() {
    }

    public Course(String id, String departmentId, String originalName, String code, String turkishName, double courseCredit, short courseAKTS, short theoreticalLessonHour, short practicalLessonHour, CourseType courseType, boolean isNeedProjectorAndComputer, boolean isTherePreCourse) {
        this.id = id;
        this.departmentId = departmentId;
        this.originalName = originalName;
        this.code = code;
        this.turkishName = turkishName;
        this.courseCredit = courseCredit;
        this.courseAKTS = courseAKTS;
        this.theoreticalLessonHour = theoreticalLessonHour;
        this.practicalLessonHour = practicalLessonHour;
        this.courseType = courseType;
        this.isNeedProjectorAndComputer = isNeedProjectorAndComputer;
        this.isTherePreCourse = isTherePreCourse;
    }

    public String getId() {
        return id;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getCode() {
        return code;
    }

    public String getTurkishName() {
        return turkishName;
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
        return Double.compare(course.courseCredit, courseCredit) == 0 && courseAKTS == course.courseAKTS && theoreticalLessonHour == course.theoreticalLessonHour && practicalLessonHour == course.practicalLessonHour && isNeedProjectorAndComputer == course.isNeedProjectorAndComputer && isTherePreCourse == course.isTherePreCourse && Objects.equals(id, course.id) && Objects.equals(departmentId, course.departmentId) && Objects.equals(originalName, course.originalName) && Objects.equals(code, course.code) && Objects.equals(turkishName, course.turkishName) && courseType == course.courseType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentId, originalName, code, turkishName, courseCredit, courseAKTS, theoreticalLessonHour, practicalLessonHour, courseType, isNeedProjectorAndComputer, isTherePreCourse);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", originalName='" + originalName + '\'' +
                ", code='" + code + '\'' +
                ", turkishName='" + turkishName + '\'' +
                ", courseCredit=" + courseCredit +
                ", courseAKTS=" + courseAKTS +
                ", theoreticalLessonHour=" + theoreticalLessonHour +
                ", practicalLessonHour=" + practicalLessonHour +
                ", courseType=" + courseType +
                ", isNeedProjectorAndComputer=" + isNeedProjectorAndComputer +
                ", isTherePreCourse=" + isTherePreCourse +
                '}';
    }
}
