package com.studentinformationsystem.registrarservice.dto.staff;

import com.studentinformationsystem.registrarservice.dto.department.DepartmentDto;
import com.studentinformationsystem.registrarservice.dto.detail.DetailDto;
import lombok.Builder;

@Builder
public class StaffDto {

    private DepartmentDto department;
    private String firstName;
    private String lastName;
    private String educationalEmail;
    private DetailDto detail;


    public StaffDto() {
    }

    public StaffDto(DepartmentDto department, String firstName, String lastName, String educationalEmail, DetailDto detail) {
        this.department = department;
        this.firstName = firstName;
        this.lastName = lastName;
        this.educationalEmail = educationalEmail;
        this.detail = detail;
    }

}
