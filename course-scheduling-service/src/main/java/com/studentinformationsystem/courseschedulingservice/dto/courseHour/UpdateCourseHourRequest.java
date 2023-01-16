package com.studentinformationsystem.courseschedulingservice.dto.courseHour;

import com.studentinformationsystem.courseschedulingservice.model.enums.DayName;
import com.studentinformationsystem.courseschedulingservice.model.enums.Hour;

import java.util.Objects;

public class UpdateCourseHourRequest {
    private Long id;
    private DayName dayName;
    private Hour hour;
    private boolean isAvailable;

    public Long getId() {
        return id;
    }

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
        UpdateCourseHourRequest that = (UpdateCourseHourRequest) o;
        return isAvailable == that.isAvailable && Objects.equals(id, that.id) && dayName == that.dayName && hour == that.hour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dayName, hour, isAvailable);
    }

    @Override
    public String toString() {
        return "UpdateCourseHourRequest{" +
                "id=" + id +
                ", dayName=" + dayName +
                ", hour=" + hour +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
