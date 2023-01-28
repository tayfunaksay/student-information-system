package com.studentinformationsystem.courseschedulingservice.model;

import com.studentinformationsystem.courseschedulingservice.model.enums.DayName;
import com.studentinformationsystem.courseschedulingservice.model.enums.Hour;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;
import java.util.Objects;

@Builder
@Entity
@Table(name = "course_hours")
public class CourseHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private String id;
    @OneToMany(mappedBy = "courseHour")
    private List<OfferedCourse> offeredCourseList;
    private DayName dayName;
    private Hour hour;

    public CourseHour() {
    }

    public CourseHour(String id, List<OfferedCourse> offeredCourseList, DayName dayName, Hour hour) {
        this.id = id;
        this.offeredCourseList = offeredCourseList;
        this.dayName = dayName;
        this.hour = hour;
    }

    public String getId() {
        return id;
    }

    public List<OfferedCourse> getOfferedCourseList() {
        return offeredCourseList;
    }

    public DayName getDayName() {
        return dayName;
    }

    public Hour getHour() {
        return hour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseHour that = (CourseHour) o;
        return Objects.equals(id, that.id) && Objects.equals(offeredCourseList, that.offeredCourseList) && dayName == that.dayName && hour == that.hour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, offeredCourseList, dayName, hour);
    }

    @Override
    public String toString() {
        return "CourseHour{" +
                "id='" + id + '\'' +
                ", offeredCourseList=" + offeredCourseList +
                ", dayName=" + dayName +
                ", hour=" + hour +
                '}';
    }
}
