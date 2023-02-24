package com.studentinformationsystem.detailservice.service;

import com.studentinformationsystem.detailservice.dto.address.AddressDto;
import com.studentinformationsystem.detailservice.dto.address.CreateAddressRequest;
import com.studentinformationsystem.detailservice.dto.address.UpdateAddressRequest;
import com.studentinformationsystem.detailservice.exception.AddressNotFoundException;
import com.studentinformationsystem.detailservice.repository.AddressRepository;
import com.studentinformationsystem.detailservice.utility.AddressMapper;
import org.springframework.stereotype.Service;

@Service
public class AddressManager implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressManager(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressDto create(CreateAddressRequest request) {
        return addressMapper.toAddressDto(addressRepository.save(addressMapper.toAddress(request)));
    }

    @Override
    public AddressDto update(UpdateAddressRequest request) {
        if (addressRepository.existsById(request.getId())) {
            return addressMapper.toAddressDto(addressRepository.save(addressMapper.toAddress(request)));
        } else {
            throw new AddressNotFoundException("Address could not found by id: " + request.getId());
        }
    }
}
