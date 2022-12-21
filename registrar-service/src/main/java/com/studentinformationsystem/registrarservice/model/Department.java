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

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<Course> courses;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<Student> students;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<Instructor> instructors;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<Staff> staffs;

    private long instructorIdOfHeadOfDepartment;

    private String name;

    private String code;


    public Department() {
        super();
    }

    public Department(String id,
                      Faculty faculty,
                      List<Course> courses,
                      List<Student> students,
                      List<Instructor> instructors,
                      List<Staff> staffs,
                      long instructorIdOfHeadOfDepartment,
                      String name,
                      String code) {
        this.id = id;
        this.faculty = faculty;
        this.courses = courses;
        this.students = students;
        this.instructors = instructors;
        this.staffs = staffs;
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

    public List<Student> getStudents() {
        return students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public long isInstructorIdOfHeadOfDepartment() {
        return instructorIdOfHeadOfDepartment;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, faculty, students, courses, instructors, instructorIdOfHeadOfDepartment, name, code);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return instructorIdOfHeadOfDepartment == that.instructorIdOfHeadOfDepartment && Objects.equals(id, that.id) && Objects.equals(faculty, that.faculty) && Objects.equals(students, that.students) && Objects.equals(courses, that.courses) && Objects.equals(instructors, that.instructors) && Objects.equals(name, that.name) && Objects.equals(code, that.code);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", faculty=" + faculty +
                ", students=" + students +
                ", courses=" + courses +
                ", instructors=" + instructors +
                ", instructorIdOfHeadOfDepartment=" + instructorIdOfHeadOfDepartment +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
