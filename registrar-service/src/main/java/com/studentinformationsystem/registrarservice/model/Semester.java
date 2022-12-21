package com.studentinformationsystem.registrarservice.model;

import jakarta.persistence.*;
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
    private Date startDate;
    private Date finishDate;


    public Semester() {
    }

    public Semester(String id, String name, Date startDate, Date finishDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
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
        return Objects.equals(id, semester.id) && Objects.equals(name, semester.name) && Objects.equals(startDate, semester.startDate) && Objects.equals(finishDate, semester.finishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate, finishDate);
    }

    @Override
    public String toString() {
        return "Semester{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
