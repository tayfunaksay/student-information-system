package com.studentinformationsystem.courseschedulingservice.model.week;

import jakarta.persistence.*;
import lombok.Builder;

@Builder
@Entity
@Table(name = "course_hours")
public class CourseHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "day_id", nullable = false)
    private Day day;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "day_id", nullable = false)
    private Hour hour;
    public CourseHour() {

    }
}
