package com.studentinformationsystem.operationservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.Objects;

@Builder
@Entity
@Table(name = "semesters")
public class Semester {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    private SemesterType semesterType;
    private Date startDate;
    private Date finishDate;


    public Semester() {
    }

    public Semester(String id, String name, SemesterType semesterType, Date startDate, Date finishDate) {
        this.id = id;
        this.name = name;
        this.semesterType = semesterType;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SemesterType getSemesterType() {
        return semesterType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Semester semester = (Semester) o;
        return Objects.equals(id, semester.id) && Objects.equals(name, semester.name) && semesterType == semester.semesterType && Objects.equals(startDate, semester.startDate) && Objects.equals(finishDate, semester.finishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, semesterType, startDate, finishDate);
    }

    @Override
    public String toString() {
        return "Semester{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", semesterType=" + semesterType +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
