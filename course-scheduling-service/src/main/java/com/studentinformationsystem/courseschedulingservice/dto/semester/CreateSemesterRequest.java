package com.studentinformationsystem.courseschedulingservice.dto.semester;

import com.studentinformationsystem.courseschedulingservice.model.enums.ClassLevel;
import com.studentinformationsystem.courseschedulingservice.model.enums.SemesterType;

import java.util.Objects;

public class CreateSemesterRequest {
    private String name;
    private ClassLevel classLevel;
    private SemesterType semesterType;

    public String getName() {
        return name;
    }

    public ClassLevel getClassLevel() {
        return classLevel;
    }

    public SemesterType getSemesterType() {
        return semesterType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateSemesterRequest that = (CreateSemesterRequest) o;
        return Objects.equals(name, that.name) && classLevel == that.classLevel && semesterType == that.semesterType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, classLevel, semesterType);
    }

    @Override
    public String toString() {
        return "CreateSemesterRequest{" +
                "name='" + name + '\'' +
                ", classLevel=" + classLevel +
                ", semesterType=" + semesterType +
                '}';
    }
}
