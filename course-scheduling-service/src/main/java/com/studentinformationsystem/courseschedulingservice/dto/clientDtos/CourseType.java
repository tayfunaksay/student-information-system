package com.studentinformationsystem.courseschedulingservice.dto.clientDtos;

public enum CourseType {
    REQUIRED(1, "Zorunlu Ders"),
    OPTIONAL(2, "Seçmeli Ders");
    public final int courseTypeValue;
    public final String courseTypeName;

    CourseType(int courseTypeValue, String courseTypeName) {
        this.courseTypeValue = courseTypeValue;
        this.courseTypeName = courseTypeName;
    }

    public int getCourseTypeValue() {
        return courseTypeValue;
    }

    public String getCourseTypeName() {
        return courseTypeName;
    }
}
