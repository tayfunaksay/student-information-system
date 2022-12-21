package com.studentinformationsystem.registrarservice.dto.instructor;

import com.studentinformationsystem.registrarservice.dto.department.DepartmentDto;
import com.studentinformationsystem.registrarservice.dto.detail.DetailDto;
import lombok.Builder;

import java.util.Objects;

@Builder
public class InstructorDto {
    private String id;
    private DepartmentDto department;
    private String firstName;
    private String lastName;
    private String educationalEmail;
    private DetailDto detail;
    private boolean isAvailableForOtherDepartment;



    public InstructorDto() {

    }

    public InstructorDto(String id, DepartmentDto department, String firstName, String lastName, String educationalEmail, DetailDto detail, boolean isAvailableForOtherDepartment) {
        this.id=id;
        this.department = department;
        this.firstName = firstName;
        this.lastName = lastName;
        this.educationalEmail = educationalEmail;
        this.detail = detail;
        this.isAvailableForOtherDepartment = isAvailableForOtherDepartment;
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

    public boolean isAvailableForOtherDepartment() {
        return isAvailableForOtherDepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstructorDto that = (InstructorDto) o;
        return isAvailableForOtherDepartment == that.isAvailableForOtherDepartment && Objects.equals(id, that.id) && Objects.equals(department, that.department) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(educationalEmail, that.educationalEmail) && Objects.equals(detail, that.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, department, firstName, lastName, educationalEmail, detail, isAvailableForOtherDepartment);
    }

    @Override
    public String toString() {
        return "InstructorDto{" +
                "id='" + id + '\'' +
                ", department=" + department +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", educationalEmail='" + educationalEmail + '\'' +
                ", detail=" + detail +
                ", isAvailableForOtherDepartment=" + isAvailableForOtherDepartment +
                '}';
    }
}
