package com.studentinformationsystem.courseschedulingservice.dto.week.hour;

import lombok.Builder;

import java.util.Objects;

@Builder
public class HourDto {
    private Long id;
    private String name;
    private int whichHourOfDay;
    private boolean isAvailableForCourses;

    public HourDto() {
    }

    public HourDto(Long id, String name, int whichHourOfDay, boolean isAvailableForCourses) {
        this.id = id;
        this.name = name;
        this.whichHourOfDay = whichHourOfDay;
        this.isAvailableForCourses = isAvailableForCourses;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWhichHourOfDay() {
        return whichHourOfDay;
    }

    public boolean isAvailableForCourses() {
        return isAvailableForCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HourDto hourDto = (HourDto) o;
        return whichHourOfDay == hourDto.whichHourOfDay && isAvailableForCourses == hourDto.isAvailableForCourses && Objects.equals(id, hourDto.id) && Objects.equals(name, hourDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, whichHourOfDay, isAvailableForCourses);
    }

    @Override
    public String toString() {
        return "HourDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", whichHourOfDay=" + whichHourOfDay +
                ", isAvailableForCourses=" + isAvailableForCourses +
                '}';
    }
}
