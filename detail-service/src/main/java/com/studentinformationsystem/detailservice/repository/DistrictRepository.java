package com.studentinformationsystem.detailservice.repository;

import com.studentinformationsystem.detailservice.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, String> {
    @Query("select d from District d where d.city.id = ?1")
    List<District> findAllByCityId (String cityId);
}
