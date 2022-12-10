package com.studentinformationsystem.registrarservice.dto.course;

public class CreateCourseRequest {

    private String originalName;
    private String turkishName;
    private String code;
    private double courseCredit;
    private short courseAKTS;
    private String departmentId;

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

    public String getDepartmentId() {
        return departmentId;
    }
}
