package com.studentinformationsystem.courseschedulingservice.repository;

import com.studentinformationsystem.courseschedulingservice.model.ClassroomForCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomForCourseRepository extends JpaRepository<ClassroomForCourse,String> {

    @Query("select c from ClassroomForCourse c where c.courseId = ?1")
    List<ClassroomForCourse> findAllByCourseIdIs(String courseId);
}
