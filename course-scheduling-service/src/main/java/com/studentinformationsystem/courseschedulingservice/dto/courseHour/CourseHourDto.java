package com.studentinformationsystem.courseschedulingservice.dto.courseHour;

import lombok.Builder;

import java.util.Objects;

@Builder
public class CourseHourDto {
    private String id;
    private String dayName;
    private String hour;
    public CourseHourDto() {
    }

    public CourseHourDto(String id, String dayName, String hour) {
        this.id = id;
        this.dayName = dayName;
        this.hour = hour;
    }

    public String getId() {
        return id;
    }

    public String getDayName() {
        return dayName;
    }

    public String getHour() {
        return hour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseHourDto that = (CourseHourDto) o;
        return Objects.equals(id, that.id) && Objects.equals(dayName, that.dayName) && Objects.equals(hour, that.hour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dayName, hour);
    }

    @Override
    public String toString() {
        return "CourseHourDto{" +
                "id='" + id + '\'' +
                ", dayName='" + dayName + '\'' +
                ", hour='" + hour + '\'' +
                '}';
    }
}
