package com.studentinformationsystem.registrarservice.repository;

import com.studentinformationsystem.registrarservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("select u from User u where u.isSentToAuthServer = false")
    List<User> findAllNotSentUserToAuthServer ();
}
