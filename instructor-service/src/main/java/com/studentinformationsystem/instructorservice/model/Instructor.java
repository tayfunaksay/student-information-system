package com.studentinformationsystem.instructorservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String firstName;
    private String lastName;
    private String educationalEmail;
    private String nationalIdentity;
    private String gender;
    private String departmentId;
    private String detailId;
    private boolean isAvailable;

    public Instructor() {
    }

    public Instructor(String id, String departmentId, String detailId, String firstName, String lastName, String nationalIdentity, String gender, String educationalEmail, boolean isAvailable) {
        this.id = id;
        this.departmentId = departmentId;
        this.detailId = detailId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalIdentity = nationalIdentity;
        this.gender = gender;
        this.educationalEmail = educationalEmail;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getDetailId() {
        return detailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public String getGender() {
        return gender;
    }

    public String getEducationalEmail() {
        return educationalEmail;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructor that = (Instructor) o;
        return isAvailable == that.isAvailable && Objects.equals(id, that.id) && Objects.equals(departmentId, that.departmentId) && Objects.equals(detailId, that.detailId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(nationalIdentity, that.nationalIdentity) && Objects.equals(gender, that.gender) && Objects.equals(educationalEmail, that.educationalEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentId, detailId, firstName, lastName, nationalIdentity, gender, educationalEmail, isAvailable);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id='" + id + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", detailId='" + detailId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalIdentity='" + nationalIdentity + '\'' +
                ", gender='" + gender + '\'' +
                ", educationalEmail='" + educationalEmail + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
