package com.studentinformationsystem.detailservice.service;

import com.studentinformationsystem.detailservice.dto.address.AddressDto;
import com.studentinformationsystem.detailservice.dto.address.CreateAddressRequest;
import com.studentinformationsystem.detailservice.dto.address.UpdateAddressRequest;

public interface AddressService {

    AddressDto create(CreateAddressRequest request);

    //void delete(String addressId);

    AddressDto update(UpdateAddressRequest request);

}
