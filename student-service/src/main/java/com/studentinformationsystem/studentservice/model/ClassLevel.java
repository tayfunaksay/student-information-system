package com.studentinformationsystem.studentservice.model;

public enum ClassLevel {
    I(1, "Birinci Sınıf"),
    II(2, "İkinci Sınıf"),
    III(3, "Üçüncü Sınıf"),
    IV(4, "Dördüncü Sınıf"),
    V(5, "Beşinci Sınıf");
    private final int classLevelValue;
    private final String classLevelName;


    ClassLevel(int classLevelValue, String classLevelName) {
        this.classLevelValue = classLevelValue;
        this.classLevelName = classLevelName;
    }

    public int getClassLevelValue() {
        return classLevelValue;
    }

    public String getClassLevelName() {
        return classLevelName;
    }
}
