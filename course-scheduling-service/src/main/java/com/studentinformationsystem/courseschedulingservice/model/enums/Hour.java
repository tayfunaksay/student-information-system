package com.studentinformationsystem.courseschedulingservice.model.enums;

public enum Hour {
    I(1, "08:30-09:15"),
    II(2, "09:25-10:10"),
    III(3, "10:20-11:05"),
    IV(4, "11:15-12:00"),
    V(5, "13:00-13:45"),
    VI(6, "13:55-14:40"),
    VII(7, "14:50-15:35"),
    VIII(8, "15:45-16:30");
    private final int hourValue;
    private final String hourName;

    Hour(int hourValue, String hourName) {
        this.hourValue = hourValue;
        this.hourName = hourName;
    }

    public int getHourValue() {
        return hourValue;
    }

    public String getHourName() {
        return hourName;
    }
}
