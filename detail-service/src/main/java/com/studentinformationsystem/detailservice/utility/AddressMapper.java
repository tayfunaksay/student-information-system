package com.studentinformationsystem.detailservice.utility;

import com.studentinformationsystem.detailservice.dto.address.AddressDto;
import com.studentinformationsystem.detailservice.dto.address.CreateAddressRequest;
import com.studentinformationsystem.detailservice.dto.address.UpdateAddressRequest;
import com.studentinformationsystem.detailservice.model.Address;

import java.util.List;

public interface AddressMapper {
    AddressDto toAddressDto(Address from);

    List<AddressDto> toAddressDtoList(List<Address> from);

    Address toAddress(CreateAddressRequest request);

    Address toAddress(UpdateAddressRequest request);


}
