package com.studentinformationsystem.operationservice.service.concretes;

import com.studentinformationsystem.operationservice.dto.department.CreateDepartmentRequest;
import com.studentinformationsystem.operationservice.dto.department.DepartmentDto;
import com.studentinformationsystem.operationservice.dto.department.UpdateDepartmentRequest;
import com.studentinformationsystem.operationservice.dto.faculty.FacultyDto;
import com.studentinformationsystem.operationservice.exception.DepartmentNotFoundException;
import com.studentinformationsystem.operationservice.model.Department;
import com.studentinformationsystem.operationservice.model.Faculty;
import com.studentinformationsystem.operationservice.repository.DepartmentRepository;
import com.studentinformationsystem.operationservice.utility.mapper.abstracts.DepartmentMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class DepartmentManagerTest {
    private DepartmentManager manager;
    private DepartmentRepository repository;
    private DepartmentMapper mapper;

    @BeforeEach
    void setUp() {
        repository = mock(DepartmentRepository.class);
        mapper = mock(DepartmentMapper.class);

        manager = new DepartmentManager(repository,mapper);
    }

    @Test
    public void testCreate_whenRequestValid_itShouldReturnCreatedDepartmentDto() {
        CreateDepartmentRequest request = CreateDepartmentRequest.builder()
                .facultyId("fac1")
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        Department departmentToSave =Department.builder()
                .id("dep1")
                .faculty(Faculty.builder()
                        .id("fac1")
                        .build())
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        Department savedDepartment =Department.builder()
                .id("dep1")
                .faculty(Faculty.builder()
                        .id("fac1")
                        .name("Mühendislik Fakültesi")
                        .build())
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        DepartmentDto departmentDto = DepartmentDto.builder()
                .id("dep1")
                .facultyDto(FacultyDto.builder()
                        .id("fac1")
                        .name("Mühendislik Fakültesi")
                        .build())
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        when(mapper.toDepartment(request)).thenReturn(departmentToSave);
        when(repository.save(departmentToSave)).thenReturn(savedDepartment);
        when(mapper.toDepartmentDto(savedDepartment)).thenReturn(departmentDto);

        DepartmentDto result = manager.create(request);

        assertEquals(result,departmentDto);

        verify(mapper).toDepartment(request);
        verify(repository).save(departmentToSave);
        verify(mapper).toDepartmentDto(savedDepartment);

    }

    @Test
    public void testUpdate_whenDepartmentIdExist_itShouldReturnUpdatedDepartmentDto() {
        UpdateDepartmentRequest request = UpdateDepartmentRequest.builder()
                .id("dep1")
                .facultyId("fac1")
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        Department departmentToUpdate =Department.builder()
                .id("dep1")
                .faculty(Faculty.builder()
                        .id("fac1")
                        .build())
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        Department updatedDepartment =Department.builder()
                .id("dep1")
                .faculty(Faculty.builder()
                        .id("fac1")
                        .name("Mühendislik Fakültesi")
                        .build())
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        DepartmentDto departmentDto = DepartmentDto.builder()
                .id("dep1")
                .facultyDto(FacultyDto.builder()
                        .id("fac1")
                        .name("Mühendislik Fakültesi")
                        .build())
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        when(repository.existsById("dep1")).thenReturn(true);
        when(mapper.toDepartment(request)).thenReturn(departmentToUpdate);
        when(repository.save(departmentToUpdate)).thenReturn(updatedDepartment);
        when(mapper.toDepartmentDto(updatedDepartment)).thenReturn(departmentDto);

        DepartmentDto result = manager.update(request);

        assertEquals(result,departmentDto);

        verify(repository).existsById("dep1");
        verify(mapper).toDepartment(request);
        verify(repository).save(departmentToUpdate);
        verify(mapper).toDepartmentDto(updatedDepartment);

    }
    @Test
    public void testUpdate_whenDepartmentIdDoesNotExist_itShouldThrowDepartmentNotFoundException() {
        UpdateDepartmentRequest request = UpdateDepartmentRequest.builder()
                .id("dep1")
                .facultyId("fac1")
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        when(repository.existsById("dep1")).thenReturn(false);

        assertThrows(DepartmentNotFoundException.class,
                ()->manager.update(request));

        verify(repository).existsById("dep1");
        verifyNoInteractions(mapper);
        verifyNoMoreInteractions(repository);

    }

    @Test
    public void testGetAllByFacultyId_whenCalledWithExistFacultyId_itShouldReturnListOfDepartmentDto() {
        Department department1 =Department.builder()
                .id("dep1")
                .faculty(Faculty.builder()
                        .id("fac1")
                        .name("Mühendislik Fakültesi")
                        .build())
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        Department department2 =Department.builder()
                .id("dep2")
                .faculty(Faculty.builder()
                        .id("fac1")
                        .name("Mühendislik Fakültesi")
                        .build())
                .name("Bilgisayar Mühendisliği")
                .code("BLG")
                .build();

        DepartmentDto departmentDto1 = DepartmentDto.builder()
                .id("dep1")
                .facultyDto(FacultyDto.builder()
                        .id("fac1")
                        .name("Mühendislik Fakültesi")
                        .build())
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        DepartmentDto departmentDto2 = DepartmentDto.builder()
                .id("dep2")
                .facultyDto(FacultyDto.builder()
                        .id("fac1")
                        .name("Mühendislik Fakültesi")
                        .build())
                .name("Bilgisayar Mühendisliği")
                .code("BLG")
                .build();

        List<Department> departmentList = List.of(department1,department2);
        List<DepartmentDto> departmentDtoList = List.of(departmentDto1,departmentDto2);

        when(repository.findAllByFacultyId("fac1")).thenReturn(departmentList);
        when(mapper.toDepartmentDtoList(departmentList)).thenReturn(departmentDtoList);

        List<DepartmentDto> result = manager.getAllByFacultyId("fac1");

        assertEquals(result,departmentDtoList);

        verify(repository).findAllByFacultyId("fac1");
        verify(mapper).toDepartmentDtoList(departmentList);
    }

    @Test
    public void testGetById_whenDepartmentIdExists_itShouldReturnExpectedDepartmentDto() {

        Department department =Department.builder()
                .id("dep1")
                .faculty(Faculty.builder()
                        .id("fac1")
                        .name("Mühendislik Fakültesi")
                        .build())
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        DepartmentDto departmentDto = DepartmentDto.builder()
                .id("dep1")
                .facultyDto(FacultyDto.builder()
                        .id("fac1")
                        .name("Mühendislik Fakültesi")
                        .build())
                .name("Endüstri Mühendisliği")
                .code("END")
                .build();

        when(repository.findById("dep1")).thenReturn(Optional.of(department));
        when(mapper.toDepartmentDto(department)).thenReturn(departmentDto);

        DepartmentDto result = manager.getById("dep1");

        assertEquals(result,departmentDto);

        verify(repository).findById("dep1");
        verify(mapper).toDepartmentDto(department);

    }
    @Test
    public void testGetById_whenDepartmentIdDoesNotExists_itShouldThrowDepartmentNotFoundException() {

        when(repository.findById("dep1")).thenReturn(Optional.empty());


        assertThrows(DepartmentNotFoundException.class,
                ()-> manager.getById("dep1"));

        verify(repository).findById("dep1");
        verifyNoMoreInteractions(repository);
        verifyNoInteractions(mapper);

    }
}