package com.studentinformationsystem.detailservice.service;

import com.studentinformationsystem.detailservice.dto.city.CityDto;
import com.studentinformationsystem.detailservice.dto.city.CreateCityRequest;
import com.studentinformationsystem.detailservice.dto.city.UpdateCityRequest;
import com.studentinformationsystem.detailservice.exception.CityNotFoundException;
import com.studentinformationsystem.detailservice.model.City;
import com.studentinformationsystem.detailservice.repository.CityRepository;
import com.studentinformationsystem.detailservice.utility.CityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CityManagerTest {
    private CityManager manager;
    private CityRepository repository;
    private CityMapper mapper;
    @BeforeEach
    void setUp() {
        repository = mock(CityRepository.class);
        mapper = mock(CityMapper.class);

        manager = new CityManager(repository,mapper);
    }

    @Test
    public void testCreate_whenRequestValid_itShouldReturnCreatedCityDto() {
        CreateCityRequest request = CreateCityRequest.builder()
                .name("Mersin")
                .plateNumber("33")
                .build();

        City cityToSave = City.builder()
                .name(request.getName())
                .plateNumber(request.getPlateNumber())
                .build();

        City savedCity = City.builder()
                .id("city1")
                .name("Mersin")
                .plateNumber("33")
                .build();

        CityDto cityDto = CityDto.builder()
                .id("city1")
                .name("Mersin")
                .plateNumber("33")
                .build();

        when(mapper.toCity(request)).thenReturn(cityToSave);
        when(repository.save(cityToSave)).thenReturn(savedCity);
        when(mapper.toCityDto(savedCity)).thenReturn(cityDto);

        CityDto result = manager.create(request);

        assertEquals(result,cityDto);

        verify(mapper).toCity(request);
        verify(repository).save(cityToSave);
        verify(mapper).toCityDto(savedCity);
    }
    @Test
    public void testUpdate_whenCityIdExists_itShouldReturnUpdatedCityDto() {
        UpdateCityRequest request = UpdateCityRequest.builder()
                .id("city1")
                .name("Mersin")
                .plateNumber("33")
                .build();

        City cityToUpdate = City.builder()
                .id(request.getId())
                .name(request.getName())
                .plateNumber(request.getPlateNumber())
                .build();

        City updatedCity = City.builder()
                .id("city1")
                .name("Mersin")
                .plateNumber("33")
                .build();

        CityDto cityDto = CityDto.builder()
                .id("city1")
                .name("Mersin")
                .plateNumber("33")
                .build();

        when(repository.existsById("city1")).thenReturn(true);
        when(mapper.toCity(request)).thenReturn(cityToUpdate);
        when(repository.save(cityToUpdate)).thenReturn(updatedCity);
        when(mapper.toCityDto(updatedCity)).thenReturn(cityDto);

        CityDto result = manager.update(request);

        assertEquals(result,cityDto);

        verify(repository).existsById("city1");
        verify(mapper).toCity(request);
        verify(repository).save(cityToUpdate);
        verify(mapper).toCityDto(updatedCity);
    }
    @Test
    public void testUpdate_whenCityIdDoesNotExist_itShouldThrowCityNotFoundException() {
        UpdateCityRequest request = UpdateCityRequest.builder()
                .id("city1")
                .name("Mersin")
                .plateNumber("33")
                .build();

        when(repository.existsById("city1")).thenReturn(false);

        assertThrows(CityNotFoundException.class,
                ()-> manager.update(request));

        verify(repository).existsById("city1");
        verifyNoMoreInteractions(repository);
        verifyNoInteractions(mapper);
    }

    @Test
    public void testGetAll_whenCalled_itShouldReturnAllCityDto() {
        City city1 = City.builder()
                .id("city1")
                .name("Mersin")
                .plateNumber("33")
                .build();

        City city2 = City.builder()
                .id("city2")
                .name("Adana")
                .plateNumber("01")
                .build();

        CityDto cityDto1 = CityDto.builder()
                .id("city1")
                .name("Mersin")
                .plateNumber("33")
                .build();
        CityDto cityDto2 = CityDto.builder()
                .id("city2")
                .name("Adana")
                .plateNumber("01")
                .build();

        List<City> cityList = List.of(city1,city2);
        List<CityDto> cityDtoList = List.of(cityDto1,cityDto2);

        when(repository.findAll()).thenReturn(cityList);
        when(mapper.toCityDtoList(cityList)).thenReturn(cityDtoList);

        List<CityDto> result = manager.getAll();

        assertEquals(result,cityDtoList);

        verify(repository).findAll();
        verify(mapper).toCityDtoList(cityList);

    }

    @Test
    public void testGetById_whenCityIdExists_itShouldReturnExpectedCityDto() {
        City city = City.builder()
                .id("city1")
                .name("Mersin")
                .plateNumber("33")
                .build();

        CityDto cityDto = CityDto.builder()
                .id("city1")
                .name("Mersin")
                .plateNumber("33")
                .build();

        when(repository.findById("city1")).thenReturn(Optional.of(city));
        when(mapper.toCityDto(city)).thenReturn(cityDto);

        CityDto result = manager.getById("city1");

        assertEquals(result,cityDto);

        verify(repository).findById(city.getId());
        verify(mapper).toCityDto(city);
    }
    @Test
    public void testGetById_whenCityIdDoesNotExist_itShouldThrowCityNotFoundException() {
        City city = City.builder()
                .id("city1")
                .name("Mersin")
                .plateNumber("33")
                .build();

        when(repository.findById("city1")).thenReturn(Optional.empty());

        assertThrows(CityNotFoundException.class,
                ()-> manager.getById("city1"));

        verify(repository).findById(city.getId());
        verifyNoMoreInteractions(repository);
        verifyNoInteractions(mapper);
    }
}