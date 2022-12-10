package com.studentinformationsystem.registrarservice.repository;

import com.studentinformationsystem.registrarservice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,String> {
}
