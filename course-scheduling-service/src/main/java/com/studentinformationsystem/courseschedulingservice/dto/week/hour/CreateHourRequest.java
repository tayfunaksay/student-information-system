package com.studentinformationsystem.courseschedulingservice.dto.week.hour;

import java.util.Objects;

public class CreateHourRequest {
    private String name;
    private int whichHourOfDay;
    private boolean isAvailableForCourses;

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
        CreateHourRequest that = (CreateHourRequest) o;
        return whichHourOfDay == that.whichHourOfDay && isAvailableForCourses == that.isAvailableForCourses && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, whichHourOfDay, isAvailableForCourses);
    }

    @Override
    public String toString() {
        return "CreateHourRequest{" +
                "name='" + name + '\'' +
                ", whichHourOfDay=" + whichHourOfDay +
                ", isAvailableForCourses=" + isAvailableForCourses +
                '}';
    }
}
