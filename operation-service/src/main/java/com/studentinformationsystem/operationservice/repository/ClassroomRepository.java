package com.studentinformationsystem.operationservice.repository;

import com.studentinformationsystem.operationservice.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom,String> {
    @Query("select c.code from Classroom c where c.id = ?1")
    Optional<String> findNameById(String classroomId);
}
