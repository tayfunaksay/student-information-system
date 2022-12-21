package com.studentinformationsystem.registrarservice.repository;

import com.studentinformationsystem.registrarservice.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, String> {
}
