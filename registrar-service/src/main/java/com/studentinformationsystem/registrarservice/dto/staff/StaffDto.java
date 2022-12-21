package com.studentinformationsystem.registrarservice.dto.staff;

import com.studentinformationsystem.registrarservice.dto.department.DepartmentDto;
import com.studentinformationsystem.registrarservice.dto.detail.DetailDto;
import lombok.Builder;

import java.util.Objects;

@Builder
public class StaffDto {

    private String id;
    private DepartmentDto department;
    private String firstName;
    private String lastName;
    private String educationalEmail;
    private DetailDto detail;


    public StaffDto() {
    }

    public StaffDto(String id, DepartmentDto department, String firstName, String lastName, String educationalEmail, DetailDto detail) {
        this.id=id;
        this.department = department;
        this.firstName = firstName;
        this.lastName = lastName;
        this.educationalEmail = educationalEmail;
        this.detail = detail;
    }

    public String getId() {
        return id;
    }

    public DepartmentDto getDepartment() {
        return department;
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

    public DetailDto getDetail() {
        return detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffDto staffDto = (StaffDto) o;
        return Objects.equals(id, staffDto.id) && Objects.equals(department, staffDto.department) && Objects.equals(firstName, staffDto.firstName) && Objects.equals(lastName, staffDto.lastName) && Objects.equals(educationalEmail, staffDto.educationalEmail) && Objects.equals(detail, staffDto.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, department, firstName, lastName, educationalEmail, detail);
    }

    @Override
    public String toString() {
        return "StaffDto{" +
                "id='" + id + '\'' +
                ", department=" + department +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", educationalEmail='" + educationalEmail + '\'' +
                ", detail=" + detail +
                '}';
    }
}
