package com.studentinformationsystem.registrarservice.repository;

import com.studentinformationsystem.registrarservice.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,String> {
}
