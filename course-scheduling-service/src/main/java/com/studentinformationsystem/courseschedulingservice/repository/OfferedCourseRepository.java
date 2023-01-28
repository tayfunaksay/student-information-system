package com.studentinformationsystem.courseschedulingservice.repository;

import com.studentinformationsystem.courseschedulingservice.model.OfferedCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferedCourseRepository extends JpaRepository<OfferedCourse,String> {
    @Query("select o from OfferedCourse o where o.departmentId = ?1 and o.semester.id = ?2")
    List<OfferedCourse> findAllByDepartmentIdAndSemesterId(String departmentId, String semesterId);
    @Query("select o from OfferedCourse o where o.course.id = ?1 and o.semester.id = ?2")
    List<OfferedCourse> findAllByCourseIdAndSemesterId(String departmentId, String semesterId);
    @Query("select o from OfferedCourse o where o.instructorId = ?1 and o.semester.id = ?2")
    List<OfferedCourse> findAllByInstructorIdAndSemesterId(String instructorId, String semesterId);
}
