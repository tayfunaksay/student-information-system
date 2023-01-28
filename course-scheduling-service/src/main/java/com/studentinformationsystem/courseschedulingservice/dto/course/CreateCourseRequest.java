package com.studentinformationsystem.courseschedulingservice.dto.course;

import com.studentinformationsystem.courseschedulingservice.model.enums.CourseType;
import com.studentinformationsystem.courseschedulingservice.model.enums.SemesterType;

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
    private SemesterType semesterType;
    private String departmentId;
    private boolean isNeedProjectorAndComputer;

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

    public String getDepartmentId() {
        return departmentId;
    }

    public boolean isNeedProjectorAndComputer() {
        return isNeedProjectorAndComputer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateCourseRequest that = (CreateCourseRequest) o;
        return Double.compare(that.courseCredit, courseCredit) == 0 && courseAKTS == that.courseAKTS && theoreticalLessonHour == that.theoreticalLessonHour && practicalLessonHour == that.practicalLessonHour && isNeedProjectorAndComputer == that.isNeedProjectorAndComputer && Objects.equals(originalName, that.originalName) && Objects.equals(turkishName, that.turkishName) && Objects.equals(code, that.code) && courseType == that.courseType && semesterType == that.semesterType && Objects.equals(departmentId, that.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originalName, turkishName, code, courseCredit, courseAKTS, theoreticalLessonHour, practicalLessonHour, courseType, semesterType, departmentId, isNeedProjectorAndComputer);
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
                ", semesterType=" + semesterType +
                ", departmentId='" + departmentId + '\'' +
                ", isNeedProjectorAndComputer=" + isNeedProjectorAndComputer +
                '}';
    }
}
