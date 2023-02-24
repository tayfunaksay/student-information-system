package com.studentinformationsystem.instructorservice.service;

import com.studentinformationsystem.instructorservice.client.CreateDefaultDetailRequest;
import com.studentinformationsystem.instructorservice.client.DepartmentServiceClient;
import com.studentinformationsystem.instructorservice.client.DetailServiceClient;
import com.studentinformationsystem.instructorservice.dto.clientDto.DepartmentDto;
import com.studentinformationsystem.instructorservice.dto.clientDto.FacultyDto;
import com.studentinformationsystem.instructorservice.dto.instructor.CreateInstructorRequest;
import com.studentinformationsystem.instructorservice.dto.instructor.InstructorDto;
import com.studentinformationsystem.instructorservice.dto.instructor.UpdateInstructorRequest;
import com.studentinformationsystem.instructorservice.exception.InstructorNotFoundException;
import com.studentinformationsystem.instructorservice.model.Instructor;
import com.studentinformationsystem.instructorservice.repository.InstructorRepository;
import com.studentinformationsystem.instructorservice.utility.InstructorMapper;
import com.studentinformationsystem.instructorservice.utility.mailGenerator.EducationalMailGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class InstructorManagerTest {
    private InstructorManager manager;
    private InstructorRepository repository;
    private InstructorMapper mapper;
    private DetailServiceClient detailServiceClient;
    private DepartmentServiceClient departmentServiceClient;

    @BeforeEach
    void setUp() {
        repository = mock(InstructorRepository.class);
        mapper = mock(InstructorMapper.class);
        detailServiceClient = mock(DetailServiceClient.class);
        departmentServiceClient = mock(DepartmentServiceClient.class);

        manager = new InstructorManager(repository, mapper, detailServiceClient, departmentServiceClient);
    }

    @Test
    public void testCreate_whenRequestValid_itShouldReturnCreatedInstructorDto() {
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

        CreateInstructorRequest request = CreateInstructorRequest.builder()
                .firstName("İrfan")
                .lastName("Solak")
                .nationalIdentity("11111111111")
                .gender("E")
                .departmentId("dep1")
                .build();

        Instructor instructorToSave = Instructor.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .educationalEmail(EducationalMailGenerator.generate(request.getFirstName(), request.getLastName()))
                .nationalIdentity(request.getNationalIdentity())
                .gender(request.getGender())
                .departmentId(request.getDepartmentId())
                .detailId(detailId)
                .build();

        Instructor savedInstructor = Instructor.builder()
                .id("inst1")
                .firstName("İrfan")
                .lastName("Solak")
                .educationalEmail("irfan.solak@deu.edu.tr")
                .nationalIdentity("11111111111")
                .gender("E")
                .departmentId("dep1")
                .detailId("detail1")
                .build();

        InstructorDto instructorDto = InstructorDto.builder()
                .id("inst1")
                .firstName("İrfan")
                .lastName("Solak")
                .educationalEmail("irfan.solak@deu.edu.tr")
                .nationalIdentity("11111111111")
                .gender("E")
                .departmentName("Endüstri Mühendisliği")
                .detailId("detail1")
                .build();

        CreateDefaultDetailRequest detailRequest = CreateDefaultDetailRequest.builder()
                .cityId("city0")
                .districtId("dist0")
                .build();

        when(departmentServiceClient.getById("dep1"))
                .thenReturn(ResponseEntity.of(Optional.of(departmentDto)));

        when(detailServiceClient.createDefaultDetail(detailRequest))
                .thenReturn(ResponseEntity.of(Optional.of("detail1")));
        when(mapper.toInstructor(request,
                detailId,
                EducationalMailGenerator.generate(request.getFirstName(), request.getLastName())))
                .thenReturn(instructorToSave);
        when(repository.save(instructorToSave)).thenReturn(savedInstructor);
        when(mapper.toInstructorDto(savedInstructor,departmentDto)).thenReturn(instructorDto);

        InstructorDto result = manager.create(request);

        assertEquals(result,instructorDto);

        verify(departmentServiceClient).getById("dep1");
        verify(detailServiceClient).createDefaultDetail(detailRequest);
        verify(mapper).toInstructor(request,
                detailId,
                EducationalMailGenerator.generate(request.getFirstName(), request.getLastName()));
        verify(repository).save(instructorToSave);
        verify(mapper).toInstructorDto(savedInstructor,departmentDto);
    }
    @Test
    public void testUpdate_whenInstructorExists_itShouldReturnUpdatedInstructorDto() {
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

        UpdateInstructorRequest request = UpdateInstructorRequest.builder()
                .firstName("İrfan")
                .lastName("Solak")
                .nationalIdentity("11111111111")
                .gender("E")
                .departmentId("dep1")
                .build();

        Instructor instructorToUpdate = Instructor.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .educationalEmail(EducationalMailGenerator.generate(request.getFirstName(), request.getLastName()))
                .nationalIdentity(request.getNationalIdentity())
                .gender(request.getGender())
                .departmentId(request.getDepartmentId())
                .detailId(detailId)
                .build();

        Instructor updatedInstructor = Instructor.builder()
                .id("inst1")
                .firstName("İrfan")
                .lastName("Solak")
                .educationalEmail("irfan.solak@deu.edu.tr")
                .nationalIdentity("11111111111")
                .gender("E")
                .departmentId("dep1")
                .detailId("detail1")
                .build();

        InstructorDto instructorDto = InstructorDto.builder()
                .id("inst1")
                .firstName("İrfan")
                .lastName("Solak")
                .educationalEmail("irfan.solak@deu.edu.tr")
                .nationalIdentity("11111111111")
                .gender("E")
                .departmentName("Endüstri Mühendisliği")
                .detailId("detail1")
                .build();
        when(repository.existsById(request.getId())).thenReturn(true);
        when(departmentServiceClient.getById("dep1"))
                .thenReturn(ResponseEntity.of(Optional.of(departmentDto)));

        when(mapper.toInstructor(request)).thenReturn(instructorToUpdate);
        when(repository.save(instructorToUpdate)).thenReturn(updatedInstructor);
        when(mapper.toInstructorDto(updatedInstructor,departmentDto)).thenReturn(instructorDto);

        InstructorDto result = manager.update(request);

        assertEquals(result,instructorDto);

        verify(repository).existsById(request.getId());
        verify(departmentServiceClient).getById("dep1");
        verify(mapper).toInstructor(request);
        verify(repository).save(instructorToUpdate);
        verify(mapper).toInstructorDto(updatedInstructor,departmentDto);
    }
    @Test
    public void testUpdate_whenInstructorDoesNotExists_itShouldThrowInstructorNotFoundException() {

        UpdateInstructorRequest request = UpdateInstructorRequest.builder()
                .firstName("İrfan")
                .lastName("Solak")
                .nationalIdentity("11111111111")
                .gender("E")
                .departmentId("dep1")
                .build();

        when(repository.existsById(request.getId())).thenReturn(false);

        assertThrows(InstructorNotFoundException.class,
                ()->manager.update(request));

        verify(repository).existsById(request.getId());
        verifyNoMoreInteractions(repository);
        verifyNoInteractions(departmentServiceClient);
        verifyNoInteractions(mapper);
    }

    @Test
    public void testGetAllByDepartmentId_whenCalled_itShouldReturnListOfInstructor() {
        DepartmentDto departmentDto = DepartmentDto.builder()
                .id("dep1")
                .facultyDto(FacultyDto.builder()
                        .id("fac1")
                        .name("Mühendislik Fakültesi")
                        .build())
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        Instructor instructor1 = Instructor.builder()
                .id("inst1")
                .firstName("İrfan")
                .lastName("Solak")
                .educationalEmail("irfan.solak@deu.edu.tr")
                .nationalIdentity("11111111111")
                .gender("E")
                .departmentId("dep1")
                .detailId("detail1")
                .build();

        Instructor instructor2 = Instructor.builder()
                .id("inst2")
                .firstName("Mehmet")
                .lastName("Uzun")
                .educationalEmail("mehmet.uzun@deu.edu.tr")
                .nationalIdentity("11111111112")
                .gender("E")
                .departmentId("dep1")
                .detailId("detail1")
                .build();

        InstructorDto instructorDto1 = InstructorDto.builder()
                .id("inst1")
                .firstName("İrfan")
                .lastName("Solak")
                .educationalEmail("irfan.solak@deu.edu.tr")
                .nationalIdentity("11111111111")
                .gender("E")
                .departmentName("Endüstri Mühendisliği")
                .detailId("detail1")
                .build();

        InstructorDto instructorDto2 = InstructorDto.builder()
                .id("inst1")
                .firstName("Mehmet")
                .lastName("Uzun")
                .educationalEmail("mehmet.uzun@deu.edu.tr")
                .nationalIdentity("11111111112")
                .gender("E")
                .departmentName("Endüstri Mühendisliği")
                .detailId("detail2")
                .build();

        List<Instructor> instructorList = List.of(instructor1,instructor2);
        List<InstructorDto> instructorDtoList = List.of(instructorDto1,instructorDto2);

        when(departmentServiceClient.getById("dep1"))
                .thenReturn(ResponseEntity.of(Optional.of(departmentDto)));
        when(repository.findAllByDepartmentId("dep1")).thenReturn(instructorList);
        when(mapper.toInstructorDto(instructor1,departmentDto)).thenReturn(instructorDto1);
        when(mapper.toInstructorDto(instructor2,departmentDto)).thenReturn(instructorDto2);

        List<InstructorDto> result = manager.getAllByDepartmentId("dep1");

        assertEquals(result,instructorDtoList);

        verify(departmentServiceClient).getById("dep1");
        verify(repository).findAllByDepartmentId("dep1");
        verify(mapper).toInstructorDto(instructor1,departmentDto);
        verify(mapper).toInstructorDto(instructor2,departmentDto);
    }
    @Test
    public void testGetById_whenInstructorIdExists_itShouldReturnExpectedInstructorDto() {
        DepartmentDto departmentDto = DepartmentDto.builder()
                .id("dep1")
                .facultyDto(FacultyDto.builder()
                        .id("fac1")
                        .name("Mühendislik Fakültesi")
                        .build())
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        Instructor instructor = Instructor.builder()
                .id("inst1")
                .firstName("İrfan")
                .lastName("Solak")
                .educationalEmail("irfan.solak@deu.edu.tr")
                .nationalIdentity("11111111111")
                .gender("E")
                .departmentId("dep1")
                .detailId("detail1")
                .build();

        InstructorDto instructorDto = InstructorDto.builder()
                .id("inst1")
                .firstName("İrfan")
                .lastName("Solak")
                .educationalEmail("irfan.solak@deu.edu.tr")
                .nationalIdentity("11111111111")
                .gender("E")
                .departmentName("Endüstri Mühendisliği")
                .detailId("detail1")
                .build();

        when(repository.findById("inst1")).thenReturn(Optional.of(instructor));
        when(departmentServiceClient.getById("dep1"))
                .thenReturn(ResponseEntity.of(Optional.of(departmentDto)));
        when(mapper.toInstructorDto(instructor,departmentDto)).thenReturn(instructorDto);

        InstructorDto result = manager.getById("inst1");

        assertEquals(result,instructorDto);

        verify(departmentServiceClient).getById("dep1");
        verify(repository).findById("inst1");
        verify(mapper).toInstructorDto(instructor,departmentDto);
    }
    @Test
    public void testGetById_whenInstructorIdDoesNotExists_itShouldThrowInstructorNotFoundException() {
        DepartmentDto departmentDto = DepartmentDto.builder()
                .id("dep1")
                .facultyDto(FacultyDto.builder()
                        .id("fac1")
                        .name("Mühendislik Fakültesi")
                        .build())
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        Instructor instructor = Instructor.builder()
                .id("inst1")
                .firstName("İrfan")
                .lastName("Solak")
                .educationalEmail("irfan.solak@deu.edu.tr")
                .nationalIdentity("11111111111")
                .gender("E")
                .departmentId("dep1")
                .detailId("detail1")
                .build();

        InstructorDto instructorDto = InstructorDto.builder()
                .id("inst1")
                .firstName("İrfan")
                .lastName("Solak")
                .educationalEmail("irfan.solak@deu.edu.tr")
                .nationalIdentity("11111111111")
                .gender("E")
                .departmentName("Endüstri Mühendisliği")
                .detailId("detail1")
                .build();

        when(repository.findById("inst1")).thenReturn(Optional.empty());

        assertThrows(InstructorNotFoundException.class,
                ()-> manager.getById("inst1"));

        verify(repository).findById("inst1");
        verifyNoMoreInteractions(repository);
        verifyNoInteractions(departmentServiceClient);
        verifyNoInteractions(mapper);
    }
}