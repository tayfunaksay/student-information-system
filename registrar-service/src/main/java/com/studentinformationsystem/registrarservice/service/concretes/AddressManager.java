package com.studentinformationsystem.registrarservice.service.concretes;

import com.studentinformationsystem.registrarservice.dto.address.AddressDto;
import com.studentinformationsystem.registrarservice.dto.address.CreateAddressRequest;
import com.studentinformationsystem.registrarservice.dto.address.UpdateAddressRequest;
import com.studentinformationsystem.registrarservice.exception.AddressNotFoundException;
import com.studentinformationsystem.registrarservice.repository.AddressRepository;
import com.studentinformationsystem.registrarservice.service.AddressService;
import com.studentinformationsystem.registrarservice.utility.mapper.abstracts.AddressMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void delete(String addressId) {
        addressRepository.deleteById(addressId);
    }

    @Override
    public AddressDto update(UpdateAddressRequest request) {
        if (addressRepository.findById(request.getId()).isEmpty()) {
            throw new AddressNotFoundException("Address could not found by id: " + request.getId());
        } else {
            return addressMapper.toAddressDto(addressRepository.save(addressMapper.toAddress(request)));
        }
    }

    @Override
    public List<AddressDto> getAll() {
        return addressMapper.toAddressDtoList(addressRepository.findAll());
    }

    @Override
    public AddressDto getById(String addressId) {
        return addressMapper.toAddressDto(addressRepository.findById(addressId)
                .orElseThrow(() -> new AddressNotFoundException("Address could not found by id: " + addressId)));
    }

}
