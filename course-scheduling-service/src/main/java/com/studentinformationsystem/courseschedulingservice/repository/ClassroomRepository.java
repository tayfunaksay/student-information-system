package com.studentinformationsystem.courseschedulingservice.repository;

import com.studentinformationsystem.courseschedulingservice.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom,String> {
    @Query("select c from Classroom c where c.departmentId = ?1")
    List<Classroom> getClassroomsByDepartmentId (String departmentId);
}
