package com.studentinformationsystem.registrarservice.utility.mapper.abstracts;

import com.studentinformationsystem.registrarservice.dto.address.AddressDto;
import com.studentinformationsystem.registrarservice.dto.address.CreateAddressRequest;
import com.studentinformationsystem.registrarservice.dto.address.UpdateAddressRequest;
import com.studentinformationsystem.registrarservice.model.Address;

import java.util.List;

public interface AddressMapper {
    AddressDto toAddressDto(Address from);
    List<AddressDto> toAddressDtoList (List<Address> from);

    Address toAddress(CreateAddressRequest request);
    Address toAddress(UpdateAddressRequest request);


}
