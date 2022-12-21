package com.studentinformationsystem.registrarservice.dto.course;

import com.studentinformationsystem.registrarservice.dto.department.DepartmentDto;
import lombok.Builder;

import java.util.Objects;

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

    public String getId() {
        return id;
    }

    public String getOriginalName() {
        return originalName;
    }

    public String getTurkishName() {
        return turkishName;
    }

    public String getCode() {
        return code;
    }

    public double getCourseCredit() {
        return courseCredit;
    }

    public short getCourseAKTS() {
        return courseAKTS;
    }

    public DepartmentDto getDepartmentDto() {
        return departmentDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseDto courseDto = (CourseDto) o;
        return Double.compare(courseDto.courseCredit, courseCredit) == 0 && courseAKTS == courseDto.courseAKTS && Objects.equals(id, courseDto.id) && Objects.equals(originalName, courseDto.originalName) && Objects.equals(turkishName, courseDto.turkishName) && Objects.equals(code, courseDto.code) && Objects.equals(departmentDto, courseDto.departmentDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, originalName, turkishName, code, courseCredit, courseAKTS, departmentDto);
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "id='" + id + '\'' +
                ", originalName='" + originalName + '\'' +
                ", turkishName='" + turkishName + '\'' +
                ", code='" + code + '\'' +
                ", courseCredit=" + courseCredit +
                ", courseAKTS=" + courseAKTS +
                ", departmentDto=" + departmentDto +
                '}';
    }
}
