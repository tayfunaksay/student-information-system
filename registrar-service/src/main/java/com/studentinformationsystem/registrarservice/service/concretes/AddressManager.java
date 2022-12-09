package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.address.AddressDto;
import com.studentinformationsystem.registrarservice.dto.address.CreateAddressRequest;
import com.studentinformationsystem.registrarservice.dto.address.UpdateAddressRequest;
import com.studentinformationsystem.registrarservice.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressManager implements AddressService {

    @Override
    public AddressDto create(CreateAddressRequest request) {
        return null;
    }

    @Override
    public AddressDto delete(long addressId) {
        return null;
    }

    @Override
    public AddressDto update(UpdateAddressRequest request) {
        return null;
    }

    @Override
    public List<AddressDto> getAll() {
        return null;
    }

    @Override
    public AddressDto getById(long addressId) {
        return null;
    }
}
