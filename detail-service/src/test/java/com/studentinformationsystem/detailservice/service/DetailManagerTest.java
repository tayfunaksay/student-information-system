package com.studentinformationsystem.detailservice.service;

import com.studentinformationsystem.detailservice.model.*;
import com.studentinformationsystem.detailservice.repository.DetailRepository;
import com.studentinformationsystem.detailservice.utility.DetailMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

class DetailManagerTest {
    private DetailManager manager;
    private DetailRepository repository;
    private DetailMapper mapper;

    @BeforeEach
    void setUp() {

        repository = mock(DetailRepository.class);
        mapper = mock(DetailMapper.class);

        manager = new DetailManager(repository, mapper);
    }

    @Test
    public void testCreateDefaultDetail_whenCalled_itShouldReturnDetailIdOfDefaultDetail() {
        Detail defaultDetail1 = Detail.builder()
                .homeAddress(Address.builder()
                        .addressType(AddressType.HOME)
                        .city(City.builder()
                                .id("city0")
                                .build())
                        .district(District.builder()
                                .id("dist0")
                                .build())
                        .build())
                .workAddress(Address.builder()
                        .addressType(AddressType.WORK)
                        .city(City.builder()
                                .id("city0")
                                .build())
                        .district(District.builder()
                                .id("dist0")
                                .build())
                        .build())
                .build();

        Detail createdDefaultDetail = Detail.builder()
                .id("defaultDetailId")
                .homeAddress(Address.builder()
                        .addressType(AddressType.HOME)
                        .city(City.builder()
                                .id("city0")
                                .name("default city")
                                .plateNumber("00")
                                .build())
                        .district(District.builder()
                                .id("dist0")
                                .name("default district")
                                .city(City.builder()
                                        .id("city0")
                                        .name("default city")
                                        .plateNumber("00")
                                        .build())
                                .build())
                        .build())
                .workAddress(Address.builder()
                        .addressType(AddressType.WORK)
                        .city(City.builder()
                                .id("city0")
                                .name("default city")
                                .plateNumber("00")
                                .build())
                        .district(District.builder()
                                .id("dist0")
                                .name("default district")
                                .city(City.builder()
                                        .id("city0")
                                        .name("default city")
                                        .plateNumber("00")
                                        .build())
                                .build())
                        .build())
                .build();

    }
}