package com.studentinformationsystem.registrarservice.repository;

import com.studentinformationsystem.registrarservice.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District, String> {
}
