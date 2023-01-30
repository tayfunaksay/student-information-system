package com.studentinformationsystem.operationservice.service.concretes;

import com.studentinformationsystem.operationservice.dto.faculty.CreateFacultyRequest;
import com.studentinformationsystem.operationservice.dto.faculty.FacultyDto;
import com.studentinformationsystem.operationservice.dto.faculty.UpdateFacultyRequest;
import com.studentinformationsystem.operationservice.exception.FacultyNotFoundException;
import com.studentinformationsystem.operationservice.model.Faculty;
import com.studentinformationsystem.operationservice.repository.FacultyRepository;
import com.studentinformationsystem.operationservice.utility.mapper.abstracts.FacultyMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class FacultyManagerTest {
    private FacultyManager facultyManager;
    private FacultyRepository facultyRepository;
    private FacultyMapper facultyMapper;

    @BeforeEach
    void setUp() {
        facultyRepository = mock(FacultyRepository.class);
        facultyMapper = mock(FacultyMapper.class);

        facultyManager = new FacultyManager(facultyRepository, facultyMapper);

    }

    @Test
    public void testCreate_whenRequestValid_itShouldReturnSavedFacultyDto() {
        CreateFacultyRequest request = CreateFacultyRequest.builder()
                .name("Mühendislik Fakültesi")
                .build();

        Faculty facultyToSave = Faculty.builder()
                .name("Mühendislik Fakültesi")
                .build();

        Faculty savedFaculty = Faculty.builder()
                .id("fac1")
                .name("Mühendislik Fakültesi")
                .build();

        FacultyDto facultyDto = FacultyDto.builder()
                .id("fac1")
                .name("Mühendislik Fakültesi")
                .build();

        when(facultyMapper.toFaculty(request)).thenReturn(facultyToSave);
        when(facultyRepository.save(facultyToSave)).thenReturn(savedFaculty);
        when(facultyMapper.toFacultyDto(savedFaculty)).thenReturn(facultyDto);

        FacultyDto result = facultyManager.create(request);

        assertEquals(result, facultyDto);

        verify(facultyMapper).toFaculty(request);
        verify(facultyRepository).save(facultyToSave);
        verify(facultyMapper).toFacultyDto(savedFaculty);
    }

    @Test
    public void testUpdate_whenFacultyIdExist_itShouldReturnUpdatedFacultyDto() {
        UpdateFacultyRequest request = UpdateFacultyRequest.builder()
                .id("fac1")
                .name("Mühendislik Fakültesi")
                .build();

        Faculty facultyToUpdate = Faculty.builder()
                .id("fac1")
                .name("Mühendislik Fakültesi")
                .build();

        Faculty updatedFaculty = Faculty.builder()
                .id("fac1")
                .name("Mühendislik Fakültesi")
                .build();

        FacultyDto facultyDto = FacultyDto.builder()
                .id("fac1")
                .name("Mühendislik Fakültesi")
                .build();


        when(facultyRepository.existsById("fac1")).thenReturn(true);
        when(facultyMapper.toFaculty(request)).thenReturn(facultyToUpdate);
        when(facultyRepository.save(facultyToUpdate)).thenReturn(updatedFaculty);
        when(facultyMapper.toFacultyDto(updatedFaculty)).thenReturn(facultyDto);

        FacultyDto result = facultyManager.update(request);

        assertEquals(result, facultyDto);

        verify(facultyRepository).existsById("fac1");
        verify(facultyMapper).toFaculty(request);
        verify(facultyRepository).save(facultyToUpdate);
        verify(facultyMapper).toFacultyDto(updatedFaculty);
    }

    @Test
    public void testUpdate_whenFacultyIdDoesNotExist_itShouldThrowFacultyNotFoundException() {
        UpdateFacultyRequest request = UpdateFacultyRequest.builder()
                .id("fac2")
                .name("İktisadi ve İdari Bilimler Fakültesi")
                .build();

        when(facultyRepository.existsById("fac2")).thenReturn(false);

        assertThrows(FacultyNotFoundException.class,
                () -> facultyManager.update(request));

        verify(facultyRepository).existsById("fac2");
        verifyNoMoreInteractions(facultyRepository);
        verifyNoInteractions(facultyMapper);

    }

    @Test
    public void testGetAll_whenCalled_itShouldReturnListOfAllFacultyAsDto() {
        Faculty faculty1 = Faculty.builder()
                .id("fac1")
                .name("Mühendislik Fakültesi")
                .build();

        Faculty faculty2 = Faculty.builder()
                .id("fac2")
                .name("İktisadi ve İdari Bilimler Fakültesi")
                .build();

        FacultyDto facultyDto1 = FacultyDto.builder()
                .id("fac1")
                .name("Mühendislik Fakültesi")
                .build();

        FacultyDto facultyDto2 = FacultyDto.builder()
                .id("fac2")
                .name("İktisadi ve İdari Bilimler Fakültesi")
                .build();

        List<Faculty> facultyList = List.of(faculty1, faculty2);
        List<FacultyDto> facultyDtoList = List.of(facultyDto1, facultyDto2);

        when(facultyRepository.findAll()).thenReturn(facultyList);
        when(facultyMapper.toFacultyDtoList(facultyList)).thenReturn(facultyDtoList);

        List<FacultyDto> result = facultyManager.getAll();

        assertEquals(result, facultyDtoList);

        verify(facultyRepository).findAll();
        verify(facultyMapper).toFacultyDtoList(facultyList);


    }

    @Test
    public void testGetById_whenFacultyIdExist_itShouldReturnExpectedFacultyDto() {
        Faculty faculty = Faculty.builder()
                .id("fac1")
                .name("Mühendislik Fakültesi")
                .build();

        FacultyDto facultyDto = FacultyDto.builder()
                .id("fac1")
                .name("Mühendislik Fakültesi")
                .build();

        when(facultyRepository.findById("fac1")).thenReturn(Optional.of(faculty));
        when(facultyMapper.toFacultyDto(faculty)).thenReturn(facultyDto);

        FacultyDto result = facultyManager.getById("fac1");

        assertEquals(result,facultyDto);

        verify(facultyRepository).findById("fac1");
        verify(facultyMapper).toFacultyDto(faculty);

    }
    @Test
    public void testGetById_whenFacultyIdDoesNotExist_itShouldThrowFacultyNotFoundException() {
        Faculty faculty1 = Faculty.builder()
                .id("fac1")
                .name("Mühendislik Fakültesi")
                .build();
        when(facultyRepository.findById("fac1")).thenReturn(Optional.empty());


        assertThrows(FacultyNotFoundException.class,
                ()->facultyManager.getById("fac1"));

        verify(facultyRepository).findById("fac1");
        verifyNoInteractions(facultyMapper);

    }
}