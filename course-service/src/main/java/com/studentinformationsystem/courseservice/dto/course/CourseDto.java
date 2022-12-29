package com.studentinformationsystem.courseservice.dto.course;

import com.studentinformationsystem.courseservice.model.CourseType;
import lombok.Builder;

@Builder
public class CourseDto {
    private String id;
    private String originalName;
    private String turkishName;
    private String code;
    private double courseCredit;
    private short courseAKTS;
    private short theoreticalLessonHour;
    private short practicalLessonHour;
    private CourseType courseType;
    private String departmentId;
    private boolean isNeedProjectorAndComputer;
    private boolean isTherePreCourse;

    public CourseDto() {
    }

    public CourseDto(String id, String originalName, String turkishName, String code, double courseCredit, short courseAKTS, short theoreticalLessonHour, short practicalLessonHour, CourseType courseType, String departmentId, boolean isNeedProjectorAndComputer, boolean isTherePreCourse) {
        this.id = id;
        this.originalName = originalName;
        this.turkishName = turkishName;
        this.code = code;
        this.courseCredit = courseCredit;
        this.courseAKTS = courseAKTS;
        this.theoreticalLessonHour = theoreticalLessonHour;
        this.practicalLessonHour = practicalLessonHour;
        this.courseType = courseType;
        this.departmentId = departmentId;
        this.isNeedProjectorAndComputer = isNeedProjectorAndComputer;
        this.isTherePreCourse = isTherePreCourse;
    }
}
