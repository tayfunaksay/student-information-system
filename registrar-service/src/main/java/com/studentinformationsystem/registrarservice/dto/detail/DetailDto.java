package com.studentinformationsystem.registrarservice.dto.detail;

import com.studentinformationsystem.registrarservice.dto.address.AddressDto;
import lombok.Builder;

import java.util.List;

@Builder
public class DetailDto {
    private String id;
    private List<AddressDto> addresses;
    private String nationalIdentity;
    private String gender;

    public DetailDto() {
    }

    public DetailDto(String id,List<AddressDto> addresses, String nationalIdentity, String gender) {
        this.id=id;
        this.addresses = addresses;
        this.nationalIdentity = nationalIdentity;
        this.gender = gender;
    }
}
