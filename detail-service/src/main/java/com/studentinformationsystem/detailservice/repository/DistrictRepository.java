package com.studentinformationsystem.detailservice.repository;

import com.studentinformationsystem.detailservice.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District, String> {
}
