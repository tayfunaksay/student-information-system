package com.studentinformationsystem.courseschedulingservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Objects;

@Builder
@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @OneToMany(mappedBy = "classroom")
    private List<OfferedCourse> offeredCourseList;
    private String departmentId;
    private String code;
    private int capacity;
    private boolean isThereProjectorAndComputer;

    public Classroom() {

    }

    public Classroom(String id, List<OfferedCourse> offeredCourseList, String departmentId, String code, int capacity, boolean isThereProjectorAndComputer) {
        this.id = id;
        this.offeredCourseList = offeredCourseList;
        this.departmentId = departmentId;
        this.code = code;
        this.capacity = capacity;
        this.isThereProjectorAndComputer = isThereProjectorAndComputer;
    }

    public String getId() {
        return id;
    }

    public List<OfferedCourse> getOfferedCourseList() {
        return offeredCourseList;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getCode() {
        return code;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isThereProjectorAndComputer() {
        return isThereProjectorAndComputer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return capacity == classroom.capacity && isThereProjectorAndComputer == classroom.isThereProjectorAndComputer && Objects.equals(id, classroom.id) && Objects.equals(offeredCourseList, classroom.offeredCourseList) && Objects.equals(departmentId, classroom.departmentId) && Objects.equals(code, classroom.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, offeredCourseList, departmentId, code, capacity, isThereProjectorAndComputer);
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id='" + id + '\'' +
                ", offeredCourseList=" + offeredCourseList +
                ", departmentId='" + departmentId + '\'' +
                ", code='" + code + '\'' +
                ", capacity=" + capacity +
                ", isThereProjectorAndComputer=" + isThereProjectorAndComputer +
                '}';
    }
}
