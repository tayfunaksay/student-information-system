package com.studentinformationsystem.studentservice.service;

import com.studentinformationsystem.studentservice.client.DetailServiceClient;
import com.studentinformationsystem.studentservice.dto.CreateStudentRequest;
import com.studentinformationsystem.studentservice.dto.StudentDto;
import com.studentinformationsystem.studentservice.dto.UpdateStudentRequest;
import com.studentinformationsystem.studentservice.exception.StudentNotFoundException;
import com.studentinformationsystem.studentservice.repository.StudentRepository;
import com.studentinformationsystem.studentservice.utility.StudentMapper;
import com.studentinformationsystem.studentservice.utility.mailGenerator.EducationalMailGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentManager implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final DetailServiceClient detailServiceClient;

    public StudentManager(StudentRepository studentRepository, StudentMapper studentMapper, DetailServiceClient detailServiceClient) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
        this.detailServiceClient = detailServiceClient;
    }

    // Her create işleminde detail-service te createDefaultDetail() metodu ile boş bir detail yaratılıyor.
    // Bu metod geriye sadece ResponceEntitiy<String detailId> dönüyor
    // Yani detail bilgileri daha sonra update edilmek üzere boş bir şekilde yaratılıyor.

    @Override
    public StudentDto create(CreateStudentRequest request) {

        return studentMapper.toStudentDto(studentRepository
                .save(studentMapper.toStudent(request,
                        detailServiceClient.createDefaultDetail().getBody(),
                        EducationalMailGenerator.generate(request.getFirstName(),request.getLastName()))));
    }

    @Override
    public void delete(String studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public StudentDto update(UpdateStudentRequest request) {
        if (studentRepository.existsById(request.getId())) {
            return studentMapper.toStudentDto(studentRepository.save(studentMapper.toStudent(request)));
        } else {
            throw new StudentNotFoundException("Student could not found by id: " + request.getId());
        }
    }

    @Override
    public List<StudentDto> getAll() {
        return studentMapper.toStudentDtoList(studentRepository.findAllByGraduatedFalse());
    }

    @Override
    public StudentDto getById(String studentId) {
        return studentMapper.toStudentDto(studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student could not found by id: " + studentId)));
    }
}
