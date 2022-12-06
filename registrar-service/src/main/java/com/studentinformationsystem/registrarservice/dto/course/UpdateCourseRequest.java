package com.studentinformationsystem.registrarservice.dto.course;

public class UpdateCourseRequest {

    private String originalName;
    private String turkishName;
    private String code;
    private double courseCredit;
    private short courseAKTS;

    public String getOriginalName() {
        return originalName;
    }

    public String getTurkishName() {
        return turkishName;
    }

    public String getCode() {
        return code;
    }

    public double getCourseCredit() {
        return courseCredit;
    }

    public short getCourseAKTS() {
        return courseAKTS;
    }
}
