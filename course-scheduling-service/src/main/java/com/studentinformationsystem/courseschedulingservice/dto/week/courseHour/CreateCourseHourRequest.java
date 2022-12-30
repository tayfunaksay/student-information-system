package com.studentinformationsystem.courseschedulingservice.dto.week.courseHour;

import com.studentinformationsystem.courseschedulingservice.model.week.DayOfWeek;
import com.studentinformationsystem.courseschedulingservice.model.week.Hour;

import java.util.Objects;

public class CreateCourseHourRequest {
    private DayOfWeek dayOfWeek;
    private Hour hour;


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
        CreateCourseHourRequest that = (CreateCourseHourRequest) o;
        return Objects.equals(dayOfWeek, that.dayOfWeek) && Objects.equals(hour, that.hour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayOfWeek, hour);
    }

    @Override
    public String toString() {
        return "CreateCourseHourRequest{" +
                "dayOfWeek=" + dayOfWeek +
                ", hour=" + hour +
                '}';
    }
}
