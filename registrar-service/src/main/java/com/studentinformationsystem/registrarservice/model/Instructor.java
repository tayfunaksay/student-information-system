package com.studentinformationsystem.registrarservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Builder
@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id", nullable = false)
    private Detail detail;

    private String firstName;
    private String lastName;
    private String educationalEmail;
    private boolean isAvailableForOtherDepartment;


    public Instructor() {
    }

    public Instructor(String id,
                      Department department,
                      Detail detail,
                      String firstName,
                      String lastName,
                      String educationalEmail,
                      boolean isAvailableForOtherDepartment) {
        this.id = id;
        this.department = department;
        this.detail = detail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.educationalEmail = educationalEmail;
        this.isAvailableForOtherDepartment = isAvailableForOtherDepartment;
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

    public boolean isAvailableForOtherDepartment() {
        return isAvailableForOtherDepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructor that = (Instructor) o;
        return isAvailableForOtherDepartment == that.isAvailableForOtherDepartment && Objects.equals(id, that.id) && Objects.equals(department, that.department) && Objects.equals(detail, that.detail) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(educationalEmail, that.educationalEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, department, detail, firstName, lastName, educationalEmail, isAvailableForOtherDepartment);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", department=" + department +
                ", detail=" + detail +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", educationalEmail='" + educationalEmail + '\'' +
                ", isAvailableForOtherDepartment=" + isAvailableForOtherDepartment +
                '}';
    }
}
