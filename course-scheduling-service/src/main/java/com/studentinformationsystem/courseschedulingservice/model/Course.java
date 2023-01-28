package com.studentinformationsystem.courseschedulingservice.model;

import com.studentinformationsystem.courseschedulingservice.model.enums.CourseType;
import com.studentinformationsystem.courseschedulingservice.model.enums.SemesterType;
import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Objects;

@Builder
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @OneToMany(mappedBy = "course")
    private List<OfferedCourse> offeredCourseList;
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

    public Course() {
    }

    public Course(String id, List<OfferedCourse> offeredCourseList, String originalName, String turkishName, String code, double courseCredit, short courseAKTS, short theoreticalLessonHour, short practicalLessonHour, CourseType courseType, SemesterType semesterType, String departmentId, boolean isNeedProjectorAndComputer) {
        this.id = id;
        this.offeredCourseList = offeredCourseList;
        this.originalName = originalName;
        this.turkishName = turkishName;
        this.code = code;
        this.courseCredit = courseCredit;
        this.courseAKTS = courseAKTS;
        this.theoreticalLessonHour = theoreticalLessonHour;
        this.practicalLessonHour = practicalLessonHour;
        this.courseType = courseType;
        this.semesterType = semesterType;
        this.departmentId = departmentId;
        this.isNeedProjectorAndComputer = isNeedProjectorAndComputer;
    }

    public String getId() {
        return id;
    }

    public List<OfferedCourse> getOfferedCourseList() {
        return offeredCourseList;
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
        Course course = (Course) o;
        return Double.compare(course.courseCredit, courseCredit) == 0 && courseAKTS == course.courseAKTS && theoreticalLessonHour == course.theoreticalLessonHour && practicalLessonHour == course.practicalLessonHour && isNeedProjectorAndComputer == course.isNeedProjectorAndComputer && Objects.equals(id, course.id) && Objects.equals(offeredCourseList, course.offeredCourseList) && Objects.equals(originalName, course.originalName) && Objects.equals(turkishName, course.turkishName) && Objects.equals(code, course.code) && courseType == course.courseType && semesterType == course.semesterType && Objects.equals(departmentId, course.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, offeredCourseList, originalName, turkishName, code, courseCredit, courseAKTS, theoreticalLessonHour, practicalLessonHour, courseType, semesterType, departmentId, isNeedProjectorAndComputer);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", offeredCourseList=" + offeredCourseList +
                ", originalName='" + originalName + '\'' +
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
