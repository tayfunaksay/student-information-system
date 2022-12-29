package com.studentinformationsystem.courseschedulingservice.model.week;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;
@Builder
@Entity
@Table(name = "hours")
public class Hour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private int whichHourOfDay;
    private boolean isAvailableForCourses;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "day")
    private List<CourseHour> courseHours;

    public Hour() {

    }
}
