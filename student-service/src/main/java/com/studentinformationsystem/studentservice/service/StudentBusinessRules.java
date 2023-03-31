package com.studentinformationsystem.studentservice.service;

import com.studentinformationsystem.studentservice.exception.BusinessRulesException;
import com.studentinformationsystem.studentservice.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentBusinessRules {

    private final StudentRepository repository;

    public StudentBusinessRules(StudentRepository repository) {
        this.repository = repository;
    }

    public void checkIfStudentNumberExists(String studentNumber) {
        if (repository.existsByStudentNumber(studentNumber)){
            throw new BusinessRulesException("Student Number already exists.");
        }
    }

    public void checkIfNationalIdentityExists(String nationalIdentity) {
        if (repository.existsByNationalIdentity(nationalIdentity)){
            throw new BusinessRulesException("National Identity already exists.");
        }
    }

    public void checkIfEmailAddressExists(String emailAddress) {
        if (repository.existsByEmailAddress(emailAddress)){
            throw new BusinessRulesException("Email Address already exists.");
        }
    }
}
