package com.studentinformationsystem.detailservice.service;

import com.studentinformationsystem.detailservice.dto.address.AddressDto;
import com.studentinformationsystem.detailservice.dto.address.CreateAddressRequest;
import com.studentinformationsystem.detailservice.dto.address.UpdateAddressRequest;
import com.studentinformationsystem.detailservice.dto.city.CityDto;
import com.studentinformationsystem.detailservice.dto.district.DistrictDto;
import com.studentinformationsystem.detailservice.exception.AddressNotFoundException;
import com.studentinformationsystem.detailservice.model.Address;
import com.studentinformationsystem.detailservice.model.AddressType;
import com.studentinformationsystem.detailservice.model.City;
import com.studentinformationsystem.detailservice.model.District;
import com.studentinformationsystem.detailservice.repository.AddressRepository;
import com.studentinformationsystem.detailservice.utility.AddressMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressManagerTest {
    private AddressManager manager;
    private AddressRepository repository;
    private AddressMapper mapper;

    @BeforeEach
    void setUp() {
        repository = mock(AddressRepository.class);
        mapper = mock(AddressMapper.class);
        manager = new AddressManager(repository,mapper);
    }

    @Test
    public void testCreate_whenRequestValid_itShouldReturnCreatedAddressDto() {
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

        District district = District.builder()
                .id("dist1")
                .name("Toroslar")
                .city(city)
                .build();

        DistrictDto districtDto = DistrictDto.builder()
                .id("dist1")
                .name("Toroslar")
                .cityName("Mersin")
                .build();

        CreateAddressRequest request = CreateAddressRequest.builder()
                .cityId("city1")
                .districtId("dist1")
                .street("Ev Adresi")
                .addressType(AddressType.HOME)
                .build();


        Address addressToSave = Address.builder()
                .city(City.builder()
                        .id(request.getCityId())
                        .build())
                .district(District.builder()
                        .id(request.getDistrictId())
                        .build())
                .street("Ev Adresi")
                .addressType(AddressType.HOME)
                .build();

        Address savedAddress = Address.builder()
                .id("address1")
                .city(city)
                .district(district)
                .street("Ev Adresi")
                .addressType(AddressType.HOME)
                .build();

        AddressDto addressDto = AddressDto.builder()
                .id("address1")
                .cityDto(cityDto)
                .districtDto(districtDto)
                .street("Ev Adresi")
                .addressType(AddressType.HOME)
                .build();

        when(mapper.toAddress(request)).thenReturn(addressToSave);
        when(repository.save(addressToSave)).thenReturn(savedAddress);
        when(mapper.toAddressDto(savedAddress)).thenReturn(addressDto);

        AddressDto result = manager.create(request);

        assertEquals(result,addressDto);

        verify(mapper).toAddress(request);
        verify(repository).save(addressToSave);
        verify(mapper).toAddressDto(savedAddress);

    }
    @Test
    public void testUpdate_whenAddressIdExists_itShouldReturnUpdatedAddressDto() {
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

        District district = District.builder()
                .id("dist1")
                .name("Toroslar")
                .city(city)
                .build();

        DistrictDto districtDto = DistrictDto.builder()
                .id("dist1")
                .name("Toroslar")
                .cityName("Mersin")
                .build();

        UpdateAddressRequest request = UpdateAddressRequest.builder()
                .id("address1")
                .cityId("city1")
                .districtId("dist1")
                .street("Ev Adresi")
                .addressType(AddressType.HOME)
                .build();


        Address addressToUpdate = Address.builder()
                .id(request.getId())
                .city(City.builder()
                        .id(request.getCityId())
                        .build())
                .district(District.builder()
                        .id(request.getDistrictId())
                        .build())
                .street("Ev Adresi")
                .addressType(AddressType.HOME)
                .build();

        Address updatedAddress = Address.builder()
                .id("address1")
                .city(city)
                .district(district)
                .street("Ev Adresi")
                .addressType(AddressType.HOME)
                .build();

        AddressDto addressDto = AddressDto.builder()
                .id("address1")
                .cityDto(cityDto)
                .districtDto(districtDto)
                .street("Ev Adresi")
                .addressType(AddressType.HOME)
                .build();

        when(repository.existsById("address1")).thenReturn(true);
        when(mapper.toAddress(request)).thenReturn(addressToUpdate);
        when(repository.save(addressToUpdate)).thenReturn(updatedAddress);
        when(mapper.toAddressDto(updatedAddress)).thenReturn(addressDto);

        AddressDto result = manager.update(request);

        assertEquals(result,addressDto);
        verify(repository).existsById(addressToUpdate.getId());
        verify(mapper).toAddress(request);
        verify(repository).save(addressToUpdate);
        verify(mapper).toAddressDto(updatedAddress);

    }
    @Test
    public void testUpdate_whenAddressIdDoesNotExist_itShouldThrowAddressNotFoundException() {
        UpdateAddressRequest request = UpdateAddressRequest.builder()
                .id("address1")
                .cityId("city1")
                .districtId("dist1")
                .street("Ev Adresi")
                .addressType(AddressType.HOME)
                .build();

        when(repository.existsById("address1")).thenReturn(false);

        assertThrows(AddressNotFoundException.class,
                ()-> manager.update(request));

        verify(repository).existsById("address1");
        verifyNoMoreInteractions(repository);
        verifyNoInteractions(mapper);
    }
}