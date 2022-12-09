package com.studentinformationsystem.registrarservice.repository;

import com.studentinformationsystem.registrarservice.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Detail,Long> {
}
