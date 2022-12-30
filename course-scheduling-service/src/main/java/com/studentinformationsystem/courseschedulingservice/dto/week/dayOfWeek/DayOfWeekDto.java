package com.studentinformationsystem.courseschedulingservice.dto.week.dayOfWeek;

import lombok.Builder;

import java.util.Objects;

@Builder
public class DayOfWeekDto {
    private Long id;
    private String name;
    private int whichDayOfWeek;
    private boolean isAvailableForCourses;

    public DayOfWeekDto() {
    }

    public DayOfWeekDto(Long id, String name, int whichDayOfWeek, boolean isAvailableForCourses) {
        this.id = id;
        this.name = name;
        this.whichDayOfWeek = whichDayOfWeek;
        this.isAvailableForCourses = isAvailableForCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayOfWeekDto dayOfWeekDto = (DayOfWeekDto) o;
        return whichDayOfWeek == dayOfWeekDto.whichDayOfWeek && isAvailableForCourses == dayOfWeekDto.isAvailableForCourses && Objects.equals(id, dayOfWeekDto.id) && Objects.equals(name, dayOfWeekDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, whichDayOfWeek, isAvailableForCourses);
    }

    @Override
    public String toString() {
        return "DayDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", whichDayOfWeek=" + whichDayOfWeek +
                ", isAvailableForCourses=" + isAvailableForCourses +
                '}';
    }
}
