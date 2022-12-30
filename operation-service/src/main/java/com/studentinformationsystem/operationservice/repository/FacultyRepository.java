package com.studentinformationsystem.operationservice.repository;

import com.studentinformationsystem.operationservice.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, String> {
}
