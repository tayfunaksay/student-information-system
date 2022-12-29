package com.studentinformationsystem.registrarservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Objects;

@Builder
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<Classroom> classrooms;

    private String instructorIdOfHeadOfDepartment;

    private String name;

    private String code;

    public Department() {
    }

    public Department(String id, Faculty faculty, List<Classroom> classrooms, String instructorIdOfHeadOfDepartment, String name, String code) {
        this.id = id;
        this.faculty = faculty;
        this.classrooms = classrooms;
        this.instructorIdOfHeadOfDepartment = instructorIdOfHeadOfDepartment;
        this.name = name;
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public String getInstructorIdOfHeadOfDepartment() {
        return instructorIdOfHeadOfDepartment;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id) && Objects.equals(faculty, that.faculty) && Objects.equals(classrooms, that.classrooms) && Objects.equals(instructorIdOfHeadOfDepartment, that.instructorIdOfHeadOfDepartment) && Objects.equals(name, that.name) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, faculty, classrooms, instructorIdOfHeadOfDepartment, name, code);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", faculty=" + faculty +
                ", classrooms=" + classrooms +
                ", instructorIdOfHeadOfDepartment='" + instructorIdOfHeadOfDepartment + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
