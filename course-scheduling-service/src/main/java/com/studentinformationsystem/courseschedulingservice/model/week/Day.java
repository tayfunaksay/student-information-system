package com.studentinformationsystem.courseschedulingservice.model.week;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Builder
@Entity
@Table(name = "days")
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private int whichDayOfWeek;
    private boolean isAvailableForCourses;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "day")
    private List<CourseHour> courseHours;

    public Day() {

    }
}
