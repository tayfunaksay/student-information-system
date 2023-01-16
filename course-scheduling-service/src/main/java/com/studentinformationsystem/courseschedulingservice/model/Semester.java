package com.studentinformationsystem.courseschedulingservice.model;

import com.studentinformationsystem.courseschedulingservice.model.enums.ClassLevel;
import com.studentinformationsystem.courseschedulingservice.model.enums.SemesterType;
import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Objects;

@Builder
@Entity
@Table(name = "semesters")
public class Semester {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @OneToMany(mappedBy = "semester")
    private List<OfferedCourse> offeredCourseList;
    private String name;
    private ClassLevel classLevel;
    private SemesterType semesterType;
    public Semester() {
    }

    public Semester(String id, String name, ClassLevel classLevel, SemesterType semesterType) {
        this.id = id;
        this.name = name;
        this.classLevel = classLevel;
        this.semesterType = semesterType;
    }

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
        Semester semester = (Semester) o;
        return Objects.equals(id, semester.id) && Objects.equals(name, semester.name) && classLevel == semester.classLevel && semesterType == semester.semesterType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, classLevel, semesterType);
    }

    @Override
    public String toString() {
        return "Semester{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", classLevel=" + classLevel +
                ", semesterType=" + semesterType +
                '}';
    }
}
