package com.studentinformationsystem.detailservice.repository;

import com.studentinformationsystem.detailservice.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Detail, String> {
}
