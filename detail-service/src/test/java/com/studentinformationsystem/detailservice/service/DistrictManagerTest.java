package com.studentinformationsystem.detailservice.service;

import com.studentinformationsystem.detailservice.dto.district.CreateDistrictRequest;
import com.studentinformationsystem.detailservice.dto.district.DistrictDto;
import com.studentinformationsystem.detailservice.dto.district.UpdateDistrictRequest;
import com.studentinformationsystem.detailservice.exception.DistrictNotFoundException;
import com.studentinformationsystem.detailservice.model.City;
import com.studentinformationsystem.detailservice.model.District;
import com.studentinformationsystem.detailservice.repository.DistrictRepository;
import com.studentinformationsystem.detailservice.utility.DistrictMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class DistrictManagerTest {
    private DistrictManager manager;
    private DistrictRepository repository;
    private DistrictMapper mapper;

    @BeforeEach
    void setUp() {
        repository = mock(DistrictRepository.class);
        mapper = mock(DistrictMapper.class);

        manager = new DistrictManager(repository, mapper);
    }

    @Test
    public void testCreate_whenRequestValid_itShouldReturnCreatedDistrictDto() {
        CreateDistrictRequest request = CreateDistrictRequest.builder()
                .name("Toroslar")
                .cityId("city1")
                .build();

        District districtToSave = District.builder()
                .name(request.getName())
                .city(City.builder()
                        .id(request.getCityId())
                        .build())
                .build();

        District savedDistrict = District.builder()
                .id("dist1")
                .name("Toroslar")
                .city(City.builder()
                        .id("city1")
                        .name("Mersin")
                        .plateNumber("33")
                        .build())
                .build();

        DistrictDto districtDto = DistrictDto.builder()
                .id("dist1")
                .name("Toroslar")
                .cityName("Mersin")
                .build();

        when(mapper.toDistrict(request)).thenReturn(districtToSave);
        when(repository.save(districtToSave)).thenReturn(savedDistrict);
        when(mapper.toDistrictDto(savedDistrict)).thenReturn(districtDto);

        DistrictDto result = manager.create(request);

        assertEquals(result, districtDto);

        verify(mapper).toDistrict(request);
        verify(repository).save(districtToSave);
        verify(mapper).toDistrictDto(savedDistrict);

    }

    @Test
    public void testUpdate_whenDistrictIdExists_itShouldReturnUpdatedDistrictDto() {
        UpdateDistrictRequest request = UpdateDistrictRequest.builder()
                .id("dist1")
                .name("Toroslar")
                .cityId("city1")
                .build();

        District districtToUpdate = District.builder()
                .id(request.getId())
                .name(request.getName())
                .city(City.builder()
                        .id(request.getCityId())
                        .build())
                .build();

        District updatedDistrict = District.builder()
                .id("dist1")
                .name("Toroslar")
                .city(City.builder()
                        .id("city1")
                        .name("Mersin")
                        .plateNumber("33")
                        .build())
                .build();

        DistrictDto districtDto = DistrictDto.builder()
                .id("dist1")
                .name("Toroslar")
                .cityName("Mersin")
                .build();
        when(repository.existsById("dist1")).thenReturn(true);
        when(mapper.toDistrict(request)).thenReturn(districtToUpdate);
        when(repository.save(districtToUpdate)).thenReturn(updatedDistrict);
        when(mapper.toDistrictDto(updatedDistrict)).thenReturn(districtDto);

        DistrictDto result = manager.update(request);

        assertEquals(result, districtDto);

        verify(mapper).toDistrict(request);
        verify(repository).save(districtToUpdate);
        verify(mapper).toDistrictDto(updatedDistrict);

    }

    @Test
    public void testUpdate_whenDistrictIdDoesNotExist_itShouldThrowDistrictNotFoundException() {
        UpdateDistrictRequest request = UpdateDistrictRequest.builder()
                .id("dist1")
                .name("Toroslar")
                .cityId("city1")
                .build();

        when(repository.existsById("dist1")).thenReturn(false);


        assertThrows(DistrictNotFoundException.class,
                () -> manager.update(request));

        verify(repository).existsById(request.getId());
        verifyNoMoreInteractions(repository);
        verifyNoInteractions(mapper);

    }

    @Test
    public void testGetAllByCityId_whenCalled_itShouldReturnListOfDistrict() {
        District district1 = District.builder()
                .id("dist1")
                .name("Toroslar")
                .city(City.builder()
                        .id("city1")
                        .name("Mersin")
                        .plateNumber("33")
                        .build())
                .build();

        District district2 = District.builder()
                .id("dist2")
                .name("Mezitli")
                .city(City.builder()
                        .id("city1")
                        .name("Mersin")
                        .plateNumber("33")
                        .build())
                .build();

        DistrictDto districtDto1 = DistrictDto.builder()
                .id("dist1")
                .name("Toroslar")
                .cityName("Mersin")
                .build();

        DistrictDto districtDto2 = DistrictDto.builder()
                .id("dist2")
                .name("Mezitli")
                .cityName("Mersin")
                .build();

        List<District> districtList = List.of(district1, district2);
        List<DistrictDto> districtDtoList = List.of(districtDto1, districtDto2);

        when(repository.findAllByCityId("city1")).thenReturn(districtList);
        when(mapper.toDistrictDtoList(districtList)).thenReturn(districtDtoList);

        List<DistrictDto> result = manager.getAllByCityId("city1");

        assertEquals(result, districtDtoList);

        verify(repository).findAllByCityId(district1.getCity().getId());
        verify(mapper).toDistrictDtoList(districtList);
    }

    @Test
    public void testGetById_whenDistrictIdExists_itShouldReturnExpectedDistrictDto() {
        District district = District.builder()
                .id("dist1")
                .name("Toroslar")
                .city(City.builder()
                        .id("city1")
                        .name("Mersin")
                        .plateNumber("33")
                        .build())
                .build();

        DistrictDto districtDto = DistrictDto.builder()
                .id("dist1")
                .name("Toroslar")
                .cityName("Mersin")
                .build();
        when(repository.findById("dist1")).thenReturn(Optional.of(district));
        when(mapper.toDistrictDto(district)).thenReturn(districtDto);

        DistrictDto result = manager.getById(district.getId());

        assertEquals(result, districtDto);

        verify(repository).findById("dist1");
        verify(mapper).toDistrictDto(district);
    }

    @Test
    public void testGetById_whenDistrictIdDoesNotExists_itShouldThrowDistrictNotFoundException() {

        when(repository.findById("dist1")).thenReturn(Optional.empty());

        assertThrows(DistrictNotFoundException.class,
                () -> manager.getById("dist1"));

        verify(repository).findById("dist1");
        verifyNoMoreInteractions(repository);
        verifyNoInteractions(mapper);
    }
}