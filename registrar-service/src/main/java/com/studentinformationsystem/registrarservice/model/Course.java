package com.studentinformationsystem.registrarservice.model;

import jakarta.persistence.*;
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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    private String originalName;
    private String code;
    private String turkishName;
    private double courseCredit;
    private short courseAKTS;
    private short theoreticalLessonHour;
    private short practicalLessonHour;

    public Course() {
    }

    public Course(String id,
                  Department department,
                  String originalName,
                  String code,
                  String turkishName,
                  double courseCredit,
                  short courseAKTS,
                  short theoreticalLessonHour,
                  short practicalLessonHour) {
        this.id = id;
        this.department = department;
        this.originalName = originalName;
        this.code = code;
        this.turkishName = turkishName;
        this.courseCredit = courseCredit;
        this.courseAKTS = courseAKTS;
        this.theoreticalLessonHour = theoreticalLessonHour;
        this.practicalLessonHour = practicalLessonHour;
    }

    public String getId() {
        return id;
    }

    public Department getDepartment() {
        return department;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && Double.compare(course.courseCredit, courseCredit) == 0 && courseAKTS == course.courseAKTS && theoreticalLessonHour == course.theoreticalLessonHour && practicalLessonHour == course.practicalLessonHour && Objects.equals(department, course.department) && Objects.equals(originalName, course.originalName) && Objects.equals(code, course.code) && Objects.equals(turkishName, course.turkishName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, department, originalName, code, turkishName, courseCredit, courseAKTS, theoreticalLessonHour, practicalLessonHour);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", department=" + department +
                ", originalName='" + originalName + '\'' +
                ", code='" + code + '\'' +
                ", turkishName='" + turkishName + '\'' +
                ", courseCredit=" + courseCredit +
                ", courseAKTS=" + courseAKTS +
                ", theoreticalLessonHour=" + theoreticalLessonHour +
                ", practicalLessonHour=" + practicalLessonHour +
                '}';
    }
}
