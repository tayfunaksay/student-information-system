package com.studentinformationsystem.registrarservice.repository;

import com.studentinformationsystem.registrarservice.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, String> {
}
