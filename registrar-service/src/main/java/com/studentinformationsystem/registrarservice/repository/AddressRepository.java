package com.studentinformationsystem.registrarservice.repository;

import com.studentinformationsystem.registrarservice.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
}
