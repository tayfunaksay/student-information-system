package com.studentinformationsystem.courseschedulingservice.dto.week.dayOfWeek;

import java.util.Objects;

public class CreateDayOfWeekRequest {
    private String name;
    private int whichDayOfWeek;
    private boolean isAvailableForCourses;

    public String getName() {
        return name;
    }

    public int getWhichDayOfWeek() {
        return whichDayOfWeek;
    }

    public boolean isAvailableForCourses() {
        return isAvailableForCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateDayOfWeekRequest that = (CreateDayOfWeekRequest) o;
        return whichDayOfWeek == that.whichDayOfWeek && isAvailableForCourses == that.isAvailableForCourses && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, whichDayOfWeek, isAvailableForCourses);
    }

    @Override
    public String toString() {
        return "CreateDayRequest{" +
                "name='" + name + '\'' +
                ", whichDayOfWeek=" + whichDayOfWeek +
                ", isAvailableForCourses=" + isAvailableForCourses +
                '}';
    }
}
