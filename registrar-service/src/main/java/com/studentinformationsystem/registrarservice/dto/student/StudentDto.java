package com.studentinformationsystem.registrarservice.dto.student;

import com.studentinformationsystem.registrarservice.dto.department.DepartmentDto;
import com.studentinformationsystem.registrarservice.dto.detail.DetailDto;
import lombok.Builder;

import java.util.Objects;

@Builder
public class StudentDto {
    private String id;
    private String firstName;
    private String lastName;
    private long studentNumber;
    private String educationalEmail;
    private String emailAddress;
    private DepartmentDto department;
    private DetailDto detail;

    public StudentDto() {
    }

    public StudentDto(String id, String firstName, String lastName, long studentNumber, String educationalEmail, String emailAddress, DepartmentDto department, DetailDto detail) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.educationalEmail = educationalEmail;
        this.emailAddress = emailAddress;
        this.department = department;
        this.detail = detail;
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

    public long getStudentNumber() {
        return studentNumber;
    }

    public String getEducationalEmail() {
        return educationalEmail;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public DepartmentDto getDepartment() {
        return department;
    }

    public DetailDto getDetail() {
        return detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDto that = (StudentDto) o;
        return studentNumber == that.studentNumber && Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(educationalEmail, that.educationalEmail) && Objects.equals(emailAddress, that.emailAddress) && Objects.equals(department, that.department) && Objects.equals(detail, that.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, studentNumber, educationalEmail, emailAddress, department, detail);
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentNumber=" + studentNumber +
                ", educationalEmail='" + educationalEmail + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", department=" + department +
                ", detail=" + detail +
                '}';
    }
}
