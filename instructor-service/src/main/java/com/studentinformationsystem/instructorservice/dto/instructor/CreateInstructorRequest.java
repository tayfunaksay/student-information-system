package com.studentinformationsystem.instructorservice.dto.instructor;

import lombok.Builder;

import java.util.Objects;

@Builder
public class CreateInstructorRequest {
    private String firstName;
    private String lastName;
    private String nationalIdentity;
    private String gender;
    private String departmentId;

    public CreateInstructorRequest() {
    }

    public CreateInstructorRequest(String firstName, String lastName, String nationalIdentity, String gender, String departmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalIdentity = nationalIdentity;
        this.gender = gender;
        this.departmentId = departmentId;
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

    public String getDepartmentId() {
        return departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateInstructorRequest that = (CreateInstructorRequest) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(nationalIdentity, that.nationalIdentity) && Objects.equals(gender, that.gender) && Objects.equals(departmentId, that.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, nationalIdentity, gender, departmentId);
    }

    @Override
    public String toString() {
        return "CreateInstructorRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalIdentity='" + nationalIdentity + '\'' +
                ", gender='" + gender + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}
