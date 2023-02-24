package com.studentinformationsystem.instructorservice.dto.instructor;

import lombok.Builder;

import java.util.Objects;
@Builder
public class UpdateInstructorRequest {
    private String id;
    private String firstName;
    private String lastName;
    private String nationalIdentity;
    private String gender;
    private String departmentId;

    public UpdateInstructorRequest() {
    }

    public UpdateInstructorRequest(String id, String firstName, String lastName, String nationalIdentity, String gender, String departmentId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalIdentity = nationalIdentity;
        this.gender = gender;
        this.departmentId = departmentId;
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
        UpdateInstructorRequest that = (UpdateInstructorRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(nationalIdentity, that.nationalIdentity) && Objects.equals(gender, that.gender) && Objects.equals(departmentId, that.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, nationalIdentity, gender, departmentId);
    }

    @Override
    public String toString() {
        return "UpdateInstructorRequest{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationalIdentity='" + nationalIdentity + '\'' +
                ", gender='" + gender + '\'' +
                ", departmentId='" + departmentId + '\'' +
                '}';
    }
}
