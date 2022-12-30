package com.studentinformationsystem.courseschedulingservice.dto.week.dayOfWeek;

import java.util.Objects;

public class UpdateDayOfWeekRequest {
    private Long id;
    private String name;
    private int whichDayOfWeek;
    private boolean isAvailableForCourses;

    public Long getId() {
        return id;
    }

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
        UpdateDayOfWeekRequest that = (UpdateDayOfWeekRequest) o;
        return whichDayOfWeek == that.whichDayOfWeek && isAvailableForCourses == that.isAvailableForCourses && Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, whichDayOfWeek, isAvailableForCourses);
    }

    @Override
    public String toString() {
        return "UpdateDayRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", whichDayOfWeek=" + whichDayOfWeek +
                ", isAvailableForCourses=" + isAvailableForCourses +
                '}';
    }
}
