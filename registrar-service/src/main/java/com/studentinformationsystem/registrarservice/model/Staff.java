package com.studentinformationsystem.registrarservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Builder
@Entity
@Table
public class Staff {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    private Detail detail;

    private String firstName;
    private String lastName;
    private String educationalEmail;

    public Staff() {
    }

    public Staff(String id, Department department, Detail detail, String firstName, String lastName, String educationalEmail) {
        this.id = id;
        this.department = department;
        this.detail = detail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.educationalEmail = educationalEmail;
    }


    public String getId() {
        return id;
    }

    public Department getDepartment() {
        return department;
    }

    public Detail getDetail() {
        return detail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEducationalEmail() {
        return educationalEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Objects.equals(id, staff.id) && Objects.equals(department, staff.department) && Objects.equals(detail, staff.detail) && Objects.equals(firstName, staff.firstName) && Objects.equals(lastName, staff.lastName) && Objects.equals(educationalEmail, staff.educationalEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, department, detail, firstName, lastName, educationalEmail);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", department=" + department +
                ", detail=" + detail +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", educationalEmail='" + educationalEmail + '\'' +
                '}';
    }
}
