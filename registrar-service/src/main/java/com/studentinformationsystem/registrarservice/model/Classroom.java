package com.studentinformationsystem.registrarservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Builder
@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;
    private String code;
    private int capacity;
    private boolean isThereProjectorAndComputer;

    public Classroom() {

    }
    public Classroom(String id, Department department, String code, int capacity, boolean isThereProjectorAndComputer) {
        this.id = id;
        this.department = department;
        this.code = code;
        this.capacity = capacity;
        this.isThereProjectorAndComputer = isThereProjectorAndComputer;
    }

    public String getId() {
        return id;
    }

    public Department getDepartment() {
        return department;
    }

    public String getCode() {
        return code;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isThereProjectorAndComputer() {
        return isThereProjectorAndComputer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return capacity == classroom.capacity && isThereProjectorAndComputer == classroom.isThereProjectorAndComputer && Objects.equals(id, classroom.id) && Objects.equals(department, classroom.department) && Objects.equals(code, classroom.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, department, code, capacity, isThereProjectorAndComputer);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id='" + id + '\'' +
                ", department=" + department +
                ", code='" + code + '\'' +
                ", capacity=" + capacity +
                ", isThereProjectorAndComputer=" + isThereProjectorAndComputer +
                '}';
    }
}
