package com.studentinformationsystem.registrarservice.dto.course;

import com.studentinformationsystem.registrarservice.dto.department.DepartmentDto;
import lombok.Builder;

@Builder
public class CourseDto {
    private String id;
    private String originalName;
    private String turkishName;
    private String code;
    private double courseCredit;
    private short courseAKTS;
    private DepartmentDto departmentDto;

    public CourseDto() {
    }

    public CourseDto(String id,
                     String originalName,
                     String code, String turkishName,
                     double courseCredit,
                     short courseAKTS,
                     DepartmentDto departmentDto) {
        this.id=id;
        this.originalName = originalName;
        this.code = code;
        this.turkishName = turkishName;
        this.courseCredit = courseCredit;
        this.courseAKTS = courseAKTS;
        this.departmentDto = departmentDto;
    }
}
