package com.studentinformationsystem.registrarservice.dto.detail;

import com.studentinformationsystem.registrarservice.dto.address.AddressDto;
import lombok.Builder;

import java.util.List;

@Builder
public class DetailDto {
    private List<AddressDto> addresses;
    private String nationalIdentity;
    private String gender;

    public DetailDto() {
    }

    public DetailDto(List<AddressDto> addresses, String nationalIdentity, String gender) {
        this.addresses = addresses;
        this.nationalIdentity = nationalIdentity;
        this.gender = gender;
    }
}
