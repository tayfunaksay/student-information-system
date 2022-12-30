package com.studentinformationsystem.courseservice.repository;

import com.studentinformationsystem.courseservice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    @Query("select c from Course c where c.id = ?1")
    Course findCourseByIdIs(String courseId);
}
