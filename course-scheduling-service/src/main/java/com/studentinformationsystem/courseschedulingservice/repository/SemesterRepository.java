package com.studentinformationsystem.courseschedulingservice.repository;

import com.studentinformationsystem.courseschedulingservice.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, String> {
}
