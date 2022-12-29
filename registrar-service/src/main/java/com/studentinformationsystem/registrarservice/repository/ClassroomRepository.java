package com.studentinformationsystem.registrarservice.repository;

import com.studentinformationsystem.registrarservice.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom,String> {
}
