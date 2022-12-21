package com.studentinformationsystem.registrarservice.dto.student;

import com.studentinformationsystem.registrarservice.dto.detail.CreateDetailRequest;

import java.util.Objects;

public class CreateStudentRequest {
    private long studentNumber;
    private String departmentId;
    private String firstName;
    private String lastName;
    private String educationalEmail;
    private CreateDetailRequest detail;
    private String emailAddress;

    public long getStudentNumber() {
        return studentNumber;
    }

    public String getDepartmentId() {
        return departmentId;
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

    public CreateDetailRequest getDetail() {
        return detail;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateStudentRequest that = (CreateStudentRequest) o;
        return studentNumber == that.studentNumber && Objects.equals(departmentId, that.departmentId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(educationalEmail, that.educationalEmail) && Objects.equals(detail, that.detail) && Objects.equals(emailAddress, that.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentNumber, departmentId, firstName, lastName, educationalEmail, detail, emailAddress);
    }

    @Override
    public String toString() {
        return "CreateStudentRequest{" +
                "studentNumber=" + studentNumber +
                ", departmentId='" + departmentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", educationalEmail='" + educationalEmail + '\'' +
                ", detail=" + detail +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
