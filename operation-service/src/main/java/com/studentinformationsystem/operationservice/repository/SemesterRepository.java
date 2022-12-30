package com.studentinformationsystem.operationservice.repository;

import com.studentinformationsystem.operationservice.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, String> {
}
