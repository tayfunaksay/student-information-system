package com.studentinformationsystem.courseservice.dto.course;

import com.studentinformationsystem.courseservice.model.CourseType;

import java.util.Objects;

public class CreateCourseRequest {

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
        CreateCourseRequest that = (CreateCourseRequest) o;
        return Double.compare(that.courseCredit, courseCredit) == 0 && courseAKTS == that.courseAKTS && theoreticalLessonHour == that.theoreticalLessonHour && practicalLessonHour == that.practicalLessonHour && isNeedProjectorAndComputer == that.isNeedProjectorAndComputer && isTherePreCourse == that.isTherePreCourse && Objects.equals(originalName, that.originalName) && Objects.equals(turkishName, that.turkishName) && Objects.equals(code, that.code) && courseType == that.courseType && Objects.equals(departmentId, that.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originalName, turkishName, code, courseCredit, courseAKTS, theoreticalLessonHour, practicalLessonHour, courseType, departmentId, isNeedProjectorAndComputer, isTherePreCourse);
    }

    @Override
    public String toString() {
        return "CreateCourseRequest{" +
                "originalName='" + originalName + '\'' +
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
