package com.studentinformationsystem.courseschedulingservice.dto.courseHour;

import com.studentinformationsystem.courseschedulingservice.model.enums.Hour;
import lombok.Builder;

import java.util.Objects;

@Builder
public class CourseHourDto {
    private Long id;
    private String dayName;
    private Hour hour;
    private boolean isAvailable;

    public CourseHourDto() {
    }

    public CourseHourDto(Long id, String dayName, Hour hour, boolean isAvailable) {
        this.id = id;
        this.dayName = dayName;
        this.hour = hour;
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public String getDayName() {
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
        CourseHourDto that = (CourseHourDto) o;
        return isAvailable == that.isAvailable && Objects.equals(id, that.id) && Objects.equals(dayName, that.dayName) && hour == that.hour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dayName, hour, isAvailable);
    }

    @Override
    public String toString() {
        return "CourseHourDto{" +
                "id=" + id +
                ", dayName='" + dayName + '\'' +
                ", hour=" + hour +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
