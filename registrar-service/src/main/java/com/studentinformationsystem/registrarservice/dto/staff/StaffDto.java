package com.studentinformationsystem.registrarservice.dto.staff;

import com.studentinformationsystem.registrarservice.dto.detail.DetailDto;
import lombok.Builder;

@Builder
public class StaffDto {

    private String departmentName;
    private String firstName;
    private String lastName;
    private String educationalEmail;
    private DetailDto detail;


    public StaffDto() {
    }

    public StaffDto(String departmentName, String firstName, String lastName, String educationalEmail, DetailDto detail) {
        this.departmentName = departmentName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.educationalEmail = educationalEmail;
        this.detail = detail;
    }

}
