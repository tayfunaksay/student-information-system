package com.studentinformationsystem.courseschedulingservice.dto.courseHour;

import com.studentinformationsystem.courseschedulingservice.model.enums.DayName;
import com.studentinformationsystem.courseschedulingservice.model.enums.Hour;

import java.util.Objects;

public class CreateCourseHourRequest {
    private DayName dayName;
    private Hour hour;
    private boolean isAvailable;

    public DayName getDayName() {
        return dayName;
    }

    public Hour getHour() {
        return hour;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateCourseHourRequest that = (CreateCourseHourRequest) o;
        return isAvailable == that.isAvailable && dayName == that.dayName && hour == that.hour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dayName, hour, isAvailable);
    }

    @Override
    public String toString() {
        return "CreateCourseHourRequest{" +
                "dayName=" + dayName +
                ", hour=" + hour +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
