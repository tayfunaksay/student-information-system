package com.studentinformationsystem.courseschedulingservice.model.week;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;
import java.util.Objects;

@Builder
@Entity
@Table(name = "days")
public class DayOfWeek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private int whichDayOfWeek;
    private boolean isAvailableForCourses;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dayOfWeek")
    private List<CourseHour> courseHours;

    public DayOfWeek() {

    }

    public DayOfWeek(Long id, String name, int whichDayOfWeek, boolean isAvailableForCourses, List<CourseHour> courseHours) {
        this.id = id;
        this.name = name;
        this.whichDayOfWeek = whichDayOfWeek;
        this.isAvailableForCourses = isAvailableForCourses;
        this.courseHours = courseHours;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWhichDayOfWeek() {
        return whichDayOfWeek;
    }

    public boolean isAvailableForCourses() {
        return isAvailableForCourses;
    }

    public List<CourseHour> getCourseHours() {
        return courseHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayOfWeek dayOfWeek = (DayOfWeek) o;
        return whichDayOfWeek == dayOfWeek.whichDayOfWeek && isAvailableForCourses == dayOfWeek.isAvailableForCourses && Objects.equals(id, dayOfWeek.id) && Objects.equals(name, dayOfWeek.name) && Objects.equals(courseHours, dayOfWeek.courseHours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, whichDayOfWeek, isAvailableForCourses, courseHours);
    }

    @Override
    public String toString() {
        return "DayOfWeek{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", whichDayOfWeek=" + whichDayOfWeek +
                ", isAvailableForCourses=" + isAvailableForCourses +
                ", courseHours=" + courseHours +
                '}';
    }
}
