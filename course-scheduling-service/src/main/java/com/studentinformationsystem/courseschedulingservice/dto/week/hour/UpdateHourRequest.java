package com.studentinformationsystem.courseschedulingservice.dto.week.hour;

import java.util.Objects;

public class UpdateHourRequest {
    private Long id;
    private String name;
    private int whichHourOfDay;
    private boolean isAvailableForCourses;

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
        UpdateHourRequest that = (UpdateHourRequest) o;
        return whichHourOfDay == that.whichHourOfDay && isAvailableForCourses == that.isAvailableForCourses && Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, whichHourOfDay, isAvailableForCourses);
    }

    @Override
    public String toString() {
        return "UpdateHourRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", whichHourOfDay=" + whichHourOfDay +
                ", isAvailableForCourses=" + isAvailableForCourses +
                '}';
    }
}
