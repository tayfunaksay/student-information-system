package com.studentinformationsystem.studentservice.dto.student;

import com.studentinformationsystem.studentservice.model.ClassLevel;
import lombok.Builder;

import java.util.Objects;

@Builder
public class StudentDto {
    private String id;
    private String firstName;
    private String lastName;
    private String studentNumber;
    private String educationalEmail;
    private String emailAddress;
    private String departmentName;
    private ClassLevel classLevel;
    private String detailId;
    private String nationalIdentity;
    private String gender;
    private boolean isGraduated;

    public StudentDto() {
    }

    public StudentDto(String id, String firstName, String lastName, String studentNumber, String educationalEmail, String emailAddress, String departmentName, ClassLevel classLevel, String detailId, String nationalIdentity, String gender, boolean isGraduated) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.educationalEmail = educationalEmail;
        this.emailAddress = emailAddress;
        this.departmentName = departmentName;
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

    public String getDepartmentName() {
        return departmentName;
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
        StudentDto that = (StudentDto) o;
        return isGraduated == that.isGraduated && Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(studentNumber, that.studentNumber) && Objects.equals(educationalEmail, that.educationalEmail) && Objects.equals(emailAddress, that.emailAddress) && Objects.equals(departmentName, that.departmentName) && classLevel == that.classLevel && Objects.equals(detailId, that.detailId) && Objects.equals(nationalIdentity, that.nationalIdentity) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, studentNumber, educationalEmail, emailAddress, departmentName, classLevel, detailId, nationalIdentity, gender, isGraduated);
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", educationalEmail='" + educationalEmail + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", classLevel=" + classLevel +
                ", detailId='" + detailId + '\'' +
                ", nationalIdentity='" + nationalIdentity + '\'' +
                ", gender='" + gender + '\'' +
                ", isGraduated=" + isGraduated +
                '}';
    }
}
