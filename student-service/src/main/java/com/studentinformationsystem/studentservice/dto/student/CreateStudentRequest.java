package com.studentinformationsystem.studentservice.dto.student;

import lombok.Builder;

import java.util.Objects;
@Builder
public class CreateStudentRequest {
    private String firstName;
    private String lastName;
    private String studentNumber;
    private String emailAddress;
    private String departmentId;
    private String nationalIdentity;
    private String gender;

    public CreateStudentRequest() {
    }

    public CreateStudentRequest(String firstName, String lastName, String studentNumber, String emailAddress, String departmentId, String nationalIdentity, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.emailAddress = emailAddress;
        this.departmentId = departmentId;
        this.nationalIdentity = nationalIdentity;
        this.gender = gender;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateStudentRequest that = (CreateStudentRequest) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(studentNumber, that.studentNumber) && Objects.equals(emailAddress, that.emailAddress) && Objects.equals(departmentId, that.departmentId) && Objects.equals(nationalIdentity, that.nationalIdentity) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, studentNumber, emailAddress, departmentId, nationalIdentity, gender);
    }

    @Override
    public String toString() {
        return "CreateStudentRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", nationalIdentity='" + nationalIdentity + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
