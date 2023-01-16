package com.studentinformationsystem.courseschedulingservice.dto.semester;

import com.studentinformationsystem.courseschedulingservice.model.enums.ClassLevel;
import com.studentinformationsystem.courseschedulingservice.model.enums.SemesterType;

import java.util.Objects;

public class UpdateSemesterRequest {
    private String id;
    private String name;
    private ClassLevel classLevel;
    private SemesterType semesterType;

    public String getId() {
        return id;
    }

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
        UpdateSemesterRequest that = (UpdateSemesterRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && classLevel == that.classLevel && semesterType == that.semesterType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, classLevel, semesterType);
    }

    @Override
    public String toString() {
        return "UpdateSemesterRequest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", classLevel=" + classLevel +
                ", semesterType=" + semesterType +
                '}';
    }
}
