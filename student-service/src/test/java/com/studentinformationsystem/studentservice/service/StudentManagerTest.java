package com.studentinformationsystem.studentservice.service;

import com.studentinformationsystem.studentservice.client.DepartmentServiceClient;
import com.studentinformationsystem.studentservice.client.DetailServiceClient;
import com.studentinformationsystem.studentservice.dto.clientDto.DepartmentDto;
import com.studentinformationsystem.studentservice.dto.clientDto.FacultyDto;
import com.studentinformationsystem.studentservice.dto.student.CreateStudentRequest;
import com.studentinformationsystem.studentservice.dto.student.StudentDto;
import com.studentinformationsystem.studentservice.dto.student.UpdateStudentRequest;
import com.studentinformationsystem.studentservice.exception.BusinessRulesException;
import com.studentinformationsystem.studentservice.exception.StudentNotFoundException;
import com.studentinformationsystem.studentservice.model.ClassLevel;
import com.studentinformationsystem.studentservice.model.Student;
import com.studentinformationsystem.studentservice.repository.StudentRepository;
import com.studentinformationsystem.studentservice.utility.StudentMapper;
import com.studentinformationsystem.studentservice.utility.mailGenerator.EducationalMailGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class StudentManagerTest {
    private StudentManager studentManager;
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;
    private StudentBusinessRules businessRules;
    private DetailServiceClient detailServiceClient;
    private DepartmentServiceClient departmentServiceClient;


    @BeforeEach
    void setUp() {
        studentRepository = mock(StudentRepository.class);
        studentMapper = mock(StudentMapper.class);
        businessRules = mock(StudentBusinessRules.class);
        detailServiceClient = mock(DetailServiceClient.class);
        departmentServiceClient = mock(DepartmentServiceClient.class);

        studentManager = new StudentManager(studentRepository, studentMapper, businessRules, detailServiceClient, departmentServiceClient);
    }

    @Test
    public void testCreate_whenRequestValid_itShouldReturnCreatedStudentDto() {
        String detailId = "detail1";

        DepartmentDto departmentDto = DepartmentDto.builder()
                .id("dep1")
                .facultyDto(FacultyDto.builder()
                        .id("fac1")
                        .name("Mühendislik Fakültesi")
                        .build())
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        CreateStudentRequest createStudentRequest = CreateStudentRequest.builder()
                .firstName("Tayfun")
                .lastName("Aksay")
                .studentNumber("2013503004")
                .emailAddress("tayfun.aksay@gmail.com")
                .departmentId("dep1")
                .nationalIdentity("11111111111")
                .gender("E")
                .build();

        Student studentToSave = Student.builder()
                .firstName(createStudentRequest.getFirstName())
                .lastName(createStudentRequest.getLastName())
                .studentNumber(createStudentRequest.getStudentNumber())
                .educationalEmail(EducationalMailGenerator
                        .generate(createStudentRequest.getFirstName(), createStudentRequest.getLastName()))
                .emailAddress(createStudentRequest.getEmailAddress())
                .departmentId(createStudentRequest.getDepartmentId())
                .detailId(detailId)
                .classLevel(ClassLevel.I)
                .nationalIdentity(createStudentRequest.getNationalIdentity())
                .gender(createStudentRequest.getGender())
                .isGraduated(false)
                .build();

        Student savedStudent = Student.builder()
                .id("studentIdValueGeneratedByUUID")
                .firstName("Tayfun")
                .lastName("Aksay")
                .studentNumber("2013503004")
                .educationalEmail("tayfun.aksay@deu.edu.tr")
                .emailAddress("tayfun.aksay@gmail.com")
                .detailId("detail1")
                .departmentId("dep1")
                .classLevel(ClassLevel.I)
                .nationalIdentity("11111111111")
                .gender("E")
                .isGraduated(false)
                .build();
        StudentDto studentDto = StudentDto.builder()
                .id("studentIdValueGeneratedByUUID")
                .firstName("Tayfun")
                .lastName("Aksay")
                .studentNumber("2013503004")
                .educationalEmail("tayfun.aksay@deu.edu.tr")
                .emailAddress("tayfun.aksay@gmail.com")
                .detailId("detail1")
                .departmentName("Endüstri Mühendisliği")
                .classLevel(ClassLevel.I)
                .nationalIdentity("11111111111")
                .gender("E")
                .isGraduated(false)
                .build();

        when(departmentServiceClient.getById("dep1"))
                .thenReturn(ResponseEntity.of(Optional.of(departmentDto)));

        when(detailServiceClient.createDefaultDetail()).thenReturn(ResponseEntity.of(Optional.of(detailId)));
        when(studentMapper.toStudent(createStudentRequest,
                detailId,
                EducationalMailGenerator.generate(createStudentRequest.getFirstName(),
                        createStudentRequest.getLastName()))).thenReturn(studentToSave);
        when(studentRepository.save(studentToSave)).thenReturn(savedStudent);
        when(studentMapper.toStudentDto(savedStudent, departmentDto)).thenReturn(studentDto);

        StudentDto result = studentManager.create(createStudentRequest);

        assertEquals(result, studentDto);

        verify(departmentServiceClient).getById("dep1");
        verify(detailServiceClient).createDefaultDetail();
        verify(studentMapper).toStudent(createStudentRequest,
                detailId,
                EducationalMailGenerator
                        .generate(createStudentRequest.getFirstName(), createStudentRequest.getLastName()));
        verify(studentRepository).save(studentToSave);
        verify(studentMapper).toStudentDto(savedStudent, departmentDto);

    }
    @Test
    public void testCreate_whenStudentNumberAlreadyExist_itShouldThrowBusinessRulesException() {

        CreateStudentRequest createStudentRequest = CreateStudentRequest.builder()
                .firstName("Tayfun")
                .lastName("Aksay")
                .studentNumber("2013503004")
                .emailAddress("tayfun.aksay@gmail.com")
                .departmentId("dep1")
                .nationalIdentity("11111111111")
                .gender("E")
                .build();

        when(studentRepository.existsByStudentNumber(createStudentRequest.getStudentNumber())).thenReturn(true);

        assertThrows(BusinessRulesException.class,
                () ->businessRules.checkIfStudentNumberExists(createStudentRequest.getStudentNumber()));


        verify(departmentServiceClient).getById("dep1");
        verify(detailServiceClient).createDefaultDetail();
        verify(studentMapper).toStudent(createStudentRequest,
                detailId,
                EducationalMailGenerator
                        .generate(createStudentRequest.getFirstName(), createStudentRequest.getLastName()));
        verify(studentRepository).save(studentToSave);
        verify(studentMapper).toStudentDto(savedStudent, departmentDto);

    }

    @Test
    public void testUpdate_whenStudentIdExists_itShouldReturnUpdatedStudentDto() {
        String detailId = "detail1";

        DepartmentDto departmentDto = DepartmentDto.builder()
                .id("dep1")
                .facultyDto(FacultyDto.builder()
                        .id("fac1")
                        .name("Mühendislik Fakültesi")
                        .build())
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        UpdateStudentRequest updateStudentRequest = UpdateStudentRequest.builder()
                .id("student1")
                .firstName("Tayfun")
                .lastName("Aksay")
                .studentNumber("2013503004")
                .emailAddress("tayfun.aksay@gmail.com")
                .departmentId("dep1")
                .classLevel(ClassLevel.I)
                .nationalIdentity("11111111111")
                .gender("E")
                .isGraduated(false)
                .build();

        Student studentToUpdate = Student.builder()
                .id(updateStudentRequest.getId())
                .firstName(updateStudentRequest.getFirstName())
                .lastName(updateStudentRequest.getLastName())
                .studentNumber(updateStudentRequest.getStudentNumber())
                .emailAddress(updateStudentRequest.getEmailAddress())
                .departmentId(updateStudentRequest.getDepartmentId())
                .classLevel(updateStudentRequest.getClassLevel())
                .nationalIdentity(updateStudentRequest.getNationalIdentity())
                .gender(updateStudentRequest.getGender())
                .isGraduated(updateStudentRequest.isGraduated())
                .build();

        Student updatedStudent = Student.builder()
                .id("student1")
                .firstName("Tayfun")
                .lastName("Aksay")
                .studentNumber("2013503004")
                .educationalEmail("tayfun.aksay@deu.edu.tr")
                .emailAddress("tayfun.aksay@gmail.com")
                .departmentId("dep1")
                .classLevel(ClassLevel.I)
                .detailId(detailId)
                .nationalIdentity("11111111111")
                .gender("E")
                .isGraduated(false)
                .build();
        StudentDto studentDto = StudentDto.builder()
                .id("student1")
                .firstName("Tayfun")
                .lastName("Aksay")
                .studentNumber("2013503004")
                .educationalEmail("tayfun.aksay@deu.edu.tr")
                .emailAddress("tayfun.aksay@gmail.com")
                .departmentName("Endüstri Mühendisliği")
                .classLevel(ClassLevel.I)
                .nationalIdentity("11111111111")
                .gender("E")
                .isGraduated(false)
                .build();

        when(studentRepository.existsById(updateStudentRequest.getId())).thenReturn(true);

        when(departmentServiceClient.getById("dep1"))
                .thenReturn(ResponseEntity.of(Optional.of(departmentDto)));

        when(studentMapper.toStudent(updateStudentRequest)).thenReturn(studentToUpdate);

        when(studentRepository.save(studentToUpdate)).thenReturn(updatedStudent);
        when(studentMapper.toStudentDto(updatedStudent, departmentDto)).thenReturn(studentDto);

        StudentDto result = studentManager.update(updateStudentRequest);

        assertEquals(result, studentDto);

        verify(studentRepository).existsById(studentToUpdate.getId());
        verify(departmentServiceClient).getById("dep1");
        verify(studentMapper).toStudent(updateStudentRequest);
        verify(studentRepository).save(studentToUpdate);
        verify(studentMapper).toStudentDto(updatedStudent, departmentDto);

    }

    @Test
    public void testUpdate_whenStudentIdDoesNotExist_itShouldThrowStudentNotFoundException() {

        UpdateStudentRequest updateStudentRequest = UpdateStudentRequest.builder()
                .id("student1")
                .firstName("Tayfun")
                .lastName("Aksay")
                .studentNumber("2013503004")
                .emailAddress("tayfun.aksay@gmail.com")
                .departmentId("dep1")
                .classLevel(ClassLevel.I)
                .nationalIdentity("11111111111")
                .gender("E")
                .isGraduated(false)
                .build();

        when(studentRepository.existsById(updateStudentRequest.getId())).thenReturn(false);

        assertThrows(StudentNotFoundException.class, () -> studentManager.update(updateStudentRequest));

        verify(studentRepository).existsById(updateStudentRequest.getId());
    }

    @Test
    public void testGetAllByDepartmentId_whenCalledWithDepartmentId_itShouldReturnListOfStudents() {
        DepartmentDto departmentDto = DepartmentDto.builder()
                .id("dep1")
                .facultyDto(FacultyDto.builder()
                        .id("fac1")
                        .name("Mühendislik Fakültesi")
                        .build())
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        Student student1 = Student.builder()
                .id("student1")
                .firstName("Tayfun")
                .lastName("Aksay")
                .studentNumber("2013503004")
                .educationalEmail("tayfun.aksay@deu.edu.tr")
                .emailAddress("tayfun.aksay@gmail.com")
                .departmentId("dep1")
                .classLevel(ClassLevel.I)
                .detailId("detail1")
                .nationalIdentity("11111111111")
                .gender("E")
                .isGraduated(false)
                .build();
        Student student2 = Student.builder()
                .id("student2")
                .firstName("Gökhan")
                .lastName("Banko")
                .studentNumber("2013503007")
                .educationalEmail("gokhan.banko@deu.edu.tr")
                .emailAddress("gokhan.banko@gmail.com")
                .departmentId("dep1")
                .classLevel(ClassLevel.II)
                .detailId("detail2")
                .nationalIdentity("11111111112")
                .gender("E")
                .isGraduated(false)
                .build();

        StudentDto studentDto1 = StudentDto.builder()
                .id("student1")
                .firstName("Tayfun")
                .lastName("Aksay")
                .studentNumber("2013503004")
                .educationalEmail("tayfun.aksay@deu.edu.tr")
                .emailAddress("tayfun.aksay@gmail.com")
                .departmentName("Endüstri Mühendisliği")
                .classLevel(ClassLevel.I)
                .detailId("detail1")
                .nationalIdentity("11111111111")
                .gender("E")
                .isGraduated(false)
                .build();

        StudentDto studentDto2 = StudentDto.builder()
                .id("student2")
                .firstName("Gökhan")
                .lastName("Banko")
                .studentNumber("2013503007")
                .educationalEmail("gokhan.banko@deu.edu.tr")
                .emailAddress("gokhan.banko@gmail.com")
                .departmentName("Endüstri Mühendisliği")
                .classLevel(ClassLevel.II)
                .nationalIdentity("11111111112")
                .gender("E")
                .isGraduated(false)
                .build();

        List<Student> studentList = List.of(student1, student2);
        List<StudentDto> studentDtoList = List.of(studentDto1, studentDto2);

        when(departmentServiceClient.getById("dep1"))
                .thenReturn(ResponseEntity.of(Optional.of(departmentDto)));

        when(studentRepository.findAllByDepartmentIdAndGraduatedFalse("dep1")).thenReturn(studentList);
        when(studentMapper.toStudentDto(student1, departmentDto)).thenReturn(studentDto1);
        when(studentMapper.toStudentDto(student2, departmentDto)).thenReturn(studentDto2);

        List<StudentDto> result = studentManager.getAllByDepartmentId("dep1");

        assertEquals(result, studentDtoList);

        verify(departmentServiceClient).getById("dep1");
        verify(studentRepository).findAllByDepartmentIdAndGraduatedFalse("dep1");
        verify(studentMapper).toStudentDto(student1, departmentDto);
        verify(studentMapper).toStudentDto(student2, departmentDto);
    }

    @Test
    public void testGetById_whenStudentIdExist_itShouldReturnExpectedStudentDto() {

        DepartmentDto departmentDto = DepartmentDto.builder()
                .id("dep1")
                .facultyDto(FacultyDto.builder()
                        .id("fac1")
                        .name("Mühendislik Fakültesi")
                        .build())
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        Student student = Student.builder()
                .id("studentIdValueGeneratedByUUID")
                .firstName("Tayfun")
                .lastName("Aksay")
                .studentNumber("2013503004")
                .educationalEmail("tayfun.aksay@deu.edu.tr")
                .emailAddress("tayfun.aksay@gmail.com")
                .detailId("detail1")
                .departmentId("dep1")
                .classLevel(ClassLevel.I)
                .nationalIdentity("11111111111")
                .gender("E")
                .isGraduated(false)
                .build();

        StudentDto studentDto = StudentDto.builder()
                .id("student1")
                .firstName("Tayfun")
                .lastName("Aksay")
                .studentNumber("2013503004")
                .educationalEmail("tayfun.aksay@deu.edu.tr")
                .emailAddress("tayfun.aksay@gmail.com")
                .detailId("detail1")
                .departmentName("Endüstri Mühendisliği")
                .classLevel(ClassLevel.I)
                .nationalIdentity("11111111111")
                .gender("E")
                .isGraduated(false)
                .build();

        when(departmentServiceClient.getById("dep1"))
                .thenReturn(ResponseEntity.of(Optional.of(departmentDto)));

        when(studentRepository.findByIdAndGraduatedFalse("student1")).thenReturn(Optional.of(student));
        when(studentMapper.toStudentDto(student,departmentDto)).thenReturn(studentDto);

        StudentDto result = studentManager.getById("student1");

        assertEquals(result,studentDto);

        verify(departmentServiceClient).getById("dep1");
        verify(studentRepository).findByIdAndGraduatedFalse("student1");
        verify(studentMapper).toStudentDto(student,departmentDto);
    }
    @Test
    public void testGetById_whenStudentIdDoesNotExist_itShouldThrowStudentNotFoundException() {

        when(studentRepository.findByIdAndGraduatedFalse("student1"))
                .thenReturn(Optional.empty());


        assertThrows(StudentNotFoundException.class,
                ()->studentManager.getById("student1"));

        verifyNoInteractions(departmentServiceClient);
        verifyNoInteractions(studentMapper);
    }
}