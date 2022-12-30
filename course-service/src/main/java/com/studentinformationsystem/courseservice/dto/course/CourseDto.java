package com.studentinformationsystem.courseservice.dto.course;

import com.studentinformationsystem.courseservice.model.CourseType;
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

    public short getTheoreticalLessonHour() {
        return theoreticalLessonHour;
    }

    public short getPracticalLessonHour() {
        return practicalLessonHour;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public boolean isNeedProjectorAndComputer() {
        return isNeedProjectorAndComputer;
    }

    public boolean isTherePreCourse() {
        return isTherePreCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseDto courseDto = (CourseDto) o;
        return Double.compare(courseDto.courseCredit, courseCredit) == 0 && courseAKTS == courseDto.courseAKTS && theoreticalLessonHour == courseDto.theoreticalLessonHour && practicalLessonHour == courseDto.practicalLessonHour && isNeedProjectorAndComputer == courseDto.isNeedProjectorAndComputer && isTherePreCourse == courseDto.isTherePreCourse && Objects.equals(id, courseDto.id) && Objects.equals(originalName, courseDto.originalName) && Objects.equals(turkishName, courseDto.turkishName) && Objects.equals(code, courseDto.code) && courseType == courseDto.courseType && Objects.equals(departmentId, courseDto.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, originalName, turkishName, code, courseCredit, courseAKTS, theoreticalLessonHour, practicalLessonHour, courseType, departmentId, isNeedProjectorAndComputer, isTherePreCourse);
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
                ", theoreticalLessonHour=" + theoreticalLessonHour +
                ", practicalLessonHour=" + practicalLessonHour +
                ", courseType=" + courseType +
                ", departmentId='" + departmentId + '\'' +
                ", isNeedProjectorAndComputer=" + isNeedProjectorAndComputer +
                ", isTherePreCourse=" + isTherePreCourse +
                '}';
    }
}
