package com.studentinformationsystem.studentservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;
import java.util.Objects;

@Builder
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String firstName;
    private String lastName;
    private String studentNumber;
    private String educationalEmail;
    private String emailAddress;
    private String departmentId;
    private String detailId;
    private String nationalIdentity;
    private String gender;
    private boolean isGraduated;


    public Student() {
    }

    public Student(String id, String departmentId, String detailId, String studentNumber, String firstName, String lastName, String educationalEmail, String emailAddress, String nationalIdentity, String gender, boolean isGraduated) {
        this.id = id;
        this.departmentId = departmentId;
        this.detailId = detailId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.educationalEmail = educationalEmail;
        this.emailAddress = emailAddress;
        this.nationalIdentity = nationalIdentity;
        this.gender = gender;
        this.isGraduated = isGraduated;
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

    public String getStudentNumber() {
        return studentNumber;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public String getGender() {
        return gender;
    }

    public boolean isGraduated() {
        return isGraduated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return isGraduated == student.isGraduated && Objects.equals(id, student.id) && Objects.equals(departmentId, student.departmentId) && Objects.equals(detailId, student.detailId) && Objects.equals(studentNumber, student.studentNumber) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(educationalEmail, student.educationalEmail) && Objects.equals(emailAddress, student.emailAddress) && Objects.equals(nationalIdentity, student.nationalIdentity) && Objects.equals(gender, student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentId, detailId, studentNumber, firstName, lastName, educationalEmail, emailAddress, nationalIdentity, gender, isGraduated);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", detailId='" + detailId + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", educationalEmail='" + educationalEmail + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", nationalIdentity='" + nationalIdentity + '\'' +
                ", gender='" + gender + '\'' +
                ", isGraduated=" + isGraduated +
                '}';
    }
}
