package com.studentinformationsystem.detailservice.repository;

import com.studentinformationsystem.detailservice.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
}
