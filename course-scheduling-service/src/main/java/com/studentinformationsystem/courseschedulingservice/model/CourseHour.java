package com.studentinformationsystem.courseschedulingservice.model;

import com.studentinformationsystem.courseschedulingservice.model.enums.DayName;
import com.studentinformationsystem.courseschedulingservice.model.enums.Hour;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.Objects;

@Builder
@Entity
@Table(name = "course_hours")
public class CourseHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private DayName dayName;
    private Hour hour;

    public CourseHour() {

    }

    public CourseHour(Long id, DayName dayName, Hour hour) {
        this.id = id;
        this.dayName = dayName;
        this.hour = hour;
    }

    public Long getId() {
        return id;
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
        return Objects.equals(id, that.id) && dayName == that.dayName && hour == that.hour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dayName, hour);
    }

    @Override
    public String toString() {
        return "CourseHour{" +
                "id=" + id +
                ", dayName=" + dayName +
                ", hour=" + hour +
                '}';
    }
}
