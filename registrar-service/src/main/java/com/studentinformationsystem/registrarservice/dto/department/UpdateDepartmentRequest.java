package com.studentinformationsystem.registrarservice.dto.department;

public class UpdateDepartmentRequest {

    private long facultyId;
    private String name;
    private String code;


    public long getFacultyId() {
        return facultyId;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

}
