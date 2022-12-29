package com.studentinformationsystem.detailservice.repository;

import com.studentinformationsystem.detailservice.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
}
