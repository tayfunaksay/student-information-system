package com.studentinformationsystem.courseschedulingservice.model.week;

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
    private boolean isAvailable;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "day_of_week_id", nullable = false)
    private DayOfWeek dayOfWeek;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hour_id", nullable = false)
    private Hour hour;

    public CourseHour() {

    }

    public CourseHour(Long id, boolean isAvailable, DayOfWeek dayOfWeek, Hour hour) {
        this.id = id;
        this.isAvailable = isAvailable;
        this.dayOfWeek = dayOfWeek;
        this.hour = hour;
    }

    public Long getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public Hour getHour() {
        return hour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseHour that = (CourseHour) o;
        return isAvailable == that.isAvailable && Objects.equals(id, that.id) && Objects.equals(dayOfWeek, that.dayOfWeek) && Objects.equals(hour, that.hour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isAvailable, dayOfWeek, hour);
    }

    @Override
    public String toString() {
        return "CourseHour{" +
                "id=" + id +
                ", isAvailable=" + isAvailable +
                ", dayOfWeek=" + dayOfWeek +
                ", hour=" + hour +
                '}';
    }
}
