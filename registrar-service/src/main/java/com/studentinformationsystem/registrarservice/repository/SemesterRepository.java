package com.studentinformationsystem.registrarservice.repository;

import com.studentinformationsystem.registrarservice.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepository extends JpaRepository<Semester,String> {
}
