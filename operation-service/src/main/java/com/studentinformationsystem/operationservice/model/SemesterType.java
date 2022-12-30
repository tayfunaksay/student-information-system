package com.studentinformationsystem.operationservice.model;

public enum SemesterType {
    FALL(1, "Güz Dönemi"),
    SPRING(2, "Bahar Dönemi");

    private final int semesterTypeValue;
    private final String semesterTypeName;

    SemesterType(int semesterTypeValue, String semesterTypeName) {
        this.semesterTypeValue = semesterTypeValue;
        this.semesterTypeName = semesterTypeName;
    }

    public int getSemesterTypeValue() {
        return semesterTypeValue;
    }

    public String getSemesterTypeName() {
        return semesterTypeName;
    }
}
