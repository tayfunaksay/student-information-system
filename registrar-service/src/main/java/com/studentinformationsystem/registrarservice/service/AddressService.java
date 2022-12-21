package com.studentinformationsystem.registrarservice.service;

import com.studentinformationsystem.registrarservice.dto.address.AddressDto;
import com.studentinformationsystem.registrarservice.dto.address.CreateAddressRequest;
import com.studentinformationsystem.registrarservice.dto.address.UpdateAddressRequest;

import java.util.List;

public interface AddressService {

    AddressDto create(CreateAddressRequest request);

    void delete(String addressId);

    AddressDto update(UpdateAddressRequest request);

    List<AddressDto> getAll();

    AddressDto getById(String addressId);

}
