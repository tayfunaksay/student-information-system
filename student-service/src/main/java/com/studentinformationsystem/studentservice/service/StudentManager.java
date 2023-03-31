package com.studentinformationsystem.studentservice.service;

import com.studentinformationsystem.studentservice.client.DepartmentServiceClient;
import com.studentinformationsystem.studentservice.client.DetailServiceClient;
import com.studentinformationsystem.studentservice.dto.clientDto.DepartmentDto;
import com.studentinformationsystem.studentservice.dto.student.CreateStudentRequest;
import com.studentinformationsystem.studentservice.dto.student.StudentDto;
import com.studentinformationsystem.studentservice.dto.student.UpdateStudentRequest;
import com.studentinformationsystem.studentservice.exception.StudentNotFoundException;
import com.studentinformationsystem.studentservice.model.Student;
import com.studentinformationsystem.studentservice.repository.StudentRepository;
import com.studentinformationsystem.studentservice.utility.StudentMapper;
import com.studentinformationsystem.studentservice.utility.mailGenerator.EducationalMailGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentManager implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final StudentBusinessRules businessRules;
    private final DetailServiceClient detailServiceClient;
    private final DepartmentServiceClient departmentServiceClient;

    DepartmentDto departmentDto;

    public StudentManager(StudentRepository studentRepository, StudentMapper studentMapper, StudentBusinessRules businessRules, DetailServiceClient detailServiceClient, DepartmentServiceClient departmentServiceClient) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.businessRules = businessRules;
        this.detailServiceClient = detailServiceClient;
        this.departmentServiceClient = departmentServiceClient;
    }

    // Her create işleminde detail-service te createDefaultDetail() metodu ile boş bir detail yaratılıyor.
    // Bu metod geriye ResponceEntitiy<DepartmentDto> dönüyor
    // Yani detail bilgileri daha sonra update edilmek üzere boş bir şekilde yaratılıyor.

    @Override
    public StudentDto create(CreateStudentRequest request) {

        businessRules.checkIfStudentNumberExists(request.getStudentNumber());
        businessRules.checkIfEmailAddressExists(request.getEmailAddress());
        businessRules.checkIfNationalIdentityExists(request.getNationalIdentity());

        departmentDto= departmentServiceClient.getById(request.getDepartmentId()).getBody();

        return studentMapper.toStudentDto(studentRepository
                .save(studentMapper.toStudent(request,
                        detailServiceClient.createDefaultDetail().getBody(),
                        EducationalMailGenerator.generate(request.getFirstName(),request.getLastName()))),departmentDto);
    }

    @Override
    public void delete(String studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public StudentDto update(UpdateStudentRequest request) {
        if (studentRepository.existsById(request.getId())) {
            departmentDto= departmentServiceClient.getById(request.getDepartmentId()).getBody();
            return studentMapper.toStudentDto(studentRepository
                    .save(studentMapper.toStudent(request)),departmentDto);
            //TODO: İş kurallarına aykırı bir güncelleme yapılmasını engelleyecek yapı kurulmalı.
        } else {
            throw new StudentNotFoundException("Student could not found by id: " + request.getId());
        }
    }

    @Override
    public List<StudentDto> getAllByDepartmentId(String departmentId) {
        departmentDto=departmentServiceClient.getById(departmentId).getBody();
        return studentRepository.findAllByDepartmentIdAndGraduatedFalse(departmentId).parallelStream()
                .map(student -> studentMapper.toStudentDto(student,departmentDto))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getById(String studentId) {
        Student student=studentRepository.findByIdAndGraduatedFalse(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student could not found by id: " + studentId));
        departmentDto= departmentServiceClient.getById(student.getDepartmentId()).getBody();
        return studentMapper.toStudentDto(student,departmentDto);
    }
}
