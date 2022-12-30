package com.studentinformationsystem.courseschedulingservice.dto.week.courseHour;

import com.studentinformationsystem.courseschedulingservice.model.week.DayOfWeek;
import com.studentinformationsystem.courseschedulingservice.model.week.Hour;

import java.util.Objects;

public class UpdateCourseHourRequest {
    private Long id;
    private DayOfWeek dayOfWeek;
    private Hour hour;

    public Long getId() {
        return id;
    }

    public DayOfWeek getDay() {
        return dayOfWeek;
    }

    public Hour getHour() {
        return hour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateCourseHourRequest that = (UpdateCourseHourRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(dayOfWeek, that.dayOfWeek) && Objects.equals(hour, that.hour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dayOfWeek, hour);
    }

    @Override
    public String toString() {
        return "UpdateCourseHourRequest{" +
                "id=" + id +
                ", dayOfWeek=" + dayOfWeek +
                ", hour=" + hour +
                '}';
    }
}
