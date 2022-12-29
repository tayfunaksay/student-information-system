package com.studentinformationsystem.studentservice.repository;

import com.studentinformationsystem.studentservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    @Query("select s from Student s where s.isGraduated = false")
    List<Student> findAllByGraduatedFalse();
}
