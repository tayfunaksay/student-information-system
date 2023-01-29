package com.studentinformationsystem.studentservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
    @Max(10)
    @Min(10)
    private String studentNumber;
    @Email
    private String educationalEmail;
    @Email
    private String emailAddress;
    private String departmentId;
    private ClassLevel classLevel;
    private String detailId;
    @Max(11)
    @Min(11)
    private String nationalIdentity;
    private String gender;
    private boolean isGraduated;

    public Student() {
    }

    public Student(String id, String firstName, String lastName, String studentNumber, String educationalEmail, String emailAddress, String departmentId, ClassLevel classLevel, String detailId, String nationalIdentity, String gender, boolean isGraduated) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.educationalEmail = educationalEmail;
        this.emailAddress = emailAddress;
        this.departmentId = departmentId;
        this.classLevel = classLevel;
        this.detailId = detailId;
        this.nationalIdentity = nationalIdentity;
        this.gender = gender;
        this.isGraduated = isGraduated;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getEducationalEmail() {
        return educationalEmail;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public ClassLevel getClassLevel() {
        return classLevel;
    }

    public String getDetailId() {
        return detailId;
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
        return isGraduated == student.isGraduated && Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(studentNumber, student.studentNumber) && Objects.equals(educationalEmail, student.educationalEmail) && Objects.equals(emailAddress, student.emailAddress) && Objects.equals(departmentId, student.departmentId) && classLevel == student.classLevel && Objects.equals(detailId, student.detailId) && Objects.equals(nationalIdentity, student.nationalIdentity) && Objects.equals(gender, student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, studentNumber, educationalEmail, emailAddress, departmentId, classLevel, detailId, nationalIdentity, gender, isGraduated);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", educationalEmail='" + educationalEmail + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", classLevel=" + classLevel +
                ", detailId='" + detailId + '\'' +
                ", nationalIdentity='" + nationalIdentity + '\'' +
                ", gender='" + gender + '\'' +
                ", isGraduated=" + isGraduated +
                '}';
    }
}
