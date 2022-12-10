package com.studentinformationsystem.registrarservice.repository;

import com.studentinformationsystem.registrarservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {
}
