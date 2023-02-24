package com.studentinformationsystem.instructorservice.repository;

import com.studentinformationsystem.instructorservice.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, String> {
    @Query("select i from Instructor i where i.departmentId = ?1")
    List<Instructor> findAllByDepartmentId(String departmentId);
}
