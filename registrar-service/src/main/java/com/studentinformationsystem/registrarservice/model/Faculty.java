package com.studentinformationsystem.registrarservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Objects;

@Builder
@Entity
@Table(name = "faculties")
public class Faculty {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "faculty")
    private List<Department> departments;

    private String name;


    public Faculty() {
    }

    public Faculty(String id, List<Department> departments, String name) {
        this.id = id;
        this.departments = departments;
        this.name = name;
    }



    public String getId() {
        return id;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(id, faculty.id) && Objects.equals(departments, faculty.departments) && Objects.equals(name, faculty.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departments, name);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", departments=" + departments +
                ", name='" + name + '\'' +
                '}';
    }
}
