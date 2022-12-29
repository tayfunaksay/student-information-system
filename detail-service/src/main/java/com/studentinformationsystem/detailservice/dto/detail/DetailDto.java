package com.studentinformationsystem.detailservice.dto.detail;

import com.studentinformationsystem.detailservice.dto.address.AddressDto;
import lombok.Builder;

import java.util.Objects;

@Builder
public class DetailDto {
    private String id;
    private AddressDto homeAddress;
    private AddressDto workAddress;

    public DetailDto() {
    }

    public DetailDto(String id, AddressDto homeAddress, AddressDto workAddress) {
        this.id = id;
        this.homeAddress = homeAddress;
        this.workAddress = workAddress;
    }

    public String getId() {
        return id;
    }

    public AddressDto getHomeAddress() {
        return homeAddress;
    }

    public AddressDto getWorkAddress() {
        return workAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailDto detailDto = (DetailDto) o;
        return Objects.equals(id, detailDto.id) && Objects.equals(homeAddress, detailDto.homeAddress) && Objects.equals(workAddress, detailDto.workAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, homeAddress, workAddress);
    }

    @Override
    public String toString() {
        return "DetailDto{" +
                "id='" + id + '\'' +
                ", homeAddress=" + homeAddress +
                ", workAddress=" + workAddress +
                '}';
    }
}
