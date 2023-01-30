package com.studentinformationsystem.operationservice.repository;

import com.studentinformationsystem.operationservice.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
    @Query("select d from Department d where d.faculty.id = ?1")
    List<Department> findAllByFacultyId(String facultyId);
}
