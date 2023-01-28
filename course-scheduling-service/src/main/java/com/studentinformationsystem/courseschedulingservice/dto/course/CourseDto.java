package com.studentinformationsystem.courseschedulingservice.dto.course;

import com.studentinformationsystem.courseschedulingservice.model.enums.CourseType;
import com.studentinformationsystem.courseschedulingservice.model.enums.SemesterType;
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
    private SemesterType semesterType;
    private String departmentName;
    private boolean isNeedProjectorAndComputer;

    public CourseDto() {
    }

    public CourseDto(String id, String originalName, String turkishName, String code, double courseCredit, short courseAKTS, short theoreticalLessonHour, short practicalLessonHour, CourseType courseType, SemesterType semesterType, String departmentName, boolean isNeedProjectorAndComputer) {
        this.id = id;
        this.originalName = originalName;
        this.turkishName = turkishName;
        this.code = code;
        this.courseCredit = courseCredit;
        this.courseAKTS = courseAKTS;
        this.theoreticalLessonHour = theoreticalLessonHour;
        this.practicalLessonHour = practicalLessonHour;
        this.courseType = courseType;
        this.semesterType = semesterType;
        this.departmentName = departmentName;
        this.isNeedProjectorAndComputer = isNeedProjectorAndComputer;
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

    public SemesterType getSemesterType() {
        return semesterType;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public boolean isNeedProjectorAndComputer() {
        return isNeedProjectorAndComputer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseDto courseDto = (CourseDto) o;
        return Double.compare(courseDto.courseCredit, courseCredit) == 0 && courseAKTS == courseDto.courseAKTS && theoreticalLessonHour == courseDto.theoreticalLessonHour && practicalLessonHour == courseDto.practicalLessonHour && isNeedProjectorAndComputer == courseDto.isNeedProjectorAndComputer && Objects.equals(id, courseDto.id) && Objects.equals(originalName, courseDto.originalName) && Objects.equals(turkishName, courseDto.turkishName) && Objects.equals(code, courseDto.code) && courseType == courseDto.courseType && semesterType == courseDto.semesterType && Objects.equals(departmentName, courseDto.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, originalName, turkishName, code, courseCredit, courseAKTS, theoreticalLessonHour, practicalLessonHour, courseType, semesterType, departmentName, isNeedProjectorAndComputer);
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
                ", semesterType=" + semesterType +
                ", departmentName='" + departmentName + '\'' +
                ", isNeedProjectorAndComputer=" + isNeedProjectorAndComputer +
                '}';
    }
}
