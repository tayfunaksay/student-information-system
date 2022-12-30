package com.studentinformationsystem.courseschedulingservice.model.week;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;
import java.util.Objects;

@Builder
@Entity
@Table(name = "hours")
public class Hour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private int whichHourOfDay;
    private boolean isAvailableForCourses;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hour")
    private List<CourseHour> courseHours;

    public Hour() {

    }

    public Hour(Long id, String name, int whichHourOfDay, boolean isAvailableForCourses, List<CourseHour> courseHours) {
        this.id = id;
        this.name = name;
        this.whichHourOfDay = whichHourOfDay;
        this.isAvailableForCourses = isAvailableForCourses;
        this.courseHours = courseHours;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWhichHourOfDay() {
        return whichHourOfDay;
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
        Hour hour = (Hour) o;
        return whichHourOfDay == hour.whichHourOfDay && isAvailableForCourses == hour.isAvailableForCourses && Objects.equals(id, hour.id) && Objects.equals(name, hour.name) && Objects.equals(courseHours, hour.courseHours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, whichHourOfDay, isAvailableForCourses, courseHours);
    }

    @Override
    public String toString() {
        return "Hour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", whichHourOfDay=" + whichHourOfDay +
                ", isAvailableForCourses=" + isAvailableForCourses +
                ", courseHours=" + courseHours +
                '}';
    }
}
