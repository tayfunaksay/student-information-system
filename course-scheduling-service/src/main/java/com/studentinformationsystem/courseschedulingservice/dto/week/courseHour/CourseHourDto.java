package com.studentinformationsystem.courseschedulingservice.dto.week.courseHour;

import com.studentinformationsystem.courseschedulingservice.model.week.DayOfWeek;
import com.studentinformationsystem.courseschedulingservice.model.week.Hour;
import lombok.Builder;

import java.util.Objects;

@Builder
public class CourseHourDto {
    private Long id;
    private DayOfWeek dayOfWeek;
    private Hour hour;
    private boolean isAvailable;

    public CourseHourDto() {
    }

    public CourseHourDto(Long id, DayOfWeek dayOfWeek, Hour hour, boolean isAvailable) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.hour = hour;
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
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
        CourseHourDto that = (CourseHourDto) o;
        return isAvailable == that.isAvailable && Objects.equals(id, that.id) && Objects.equals(dayOfWeek, that.dayOfWeek) && Objects.equals(hour, that.hour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dayOfWeek, hour, isAvailable);
    }

    @Override
    public String toString() {
        return "CourseHourDto{" +
                "id=" + id +
                ", dayOfWeek=" + dayOfWeek +
                ", hour=" + hour +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
