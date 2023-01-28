package com.studentinformationsystem.courseregistryservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

@Builder
@Entity
@Table(name = "student_course_registrations")
public class StudentCourseRegistration {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String studentId;
    private String offeredCourseId;

    public StudentCourseRegistration() {
    }
}
