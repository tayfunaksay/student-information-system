package com.studentinformationsystem.registrarservice.dto.detail;

import com.studentinformationsystem.registrarservice.dto.address.AddressDto;
import lombok.Builder;

import java.util.Objects;

@Builder
public class DetailDto {
    private String id;
    private AddressDto homeAddress;
    private AddressDto workAddress;
    private String nationalIdentity;
    private String gender;

    public DetailDto() {
    }

    public DetailDto(String id, AddressDto homeAddress, AddressDto workAddress, String nationalIdentity, String gender) {
        this.id = id;
        this.homeAddress = homeAddress;
        this.workAddress = workAddress;
        this.nationalIdentity = nationalIdentity;
        this.gender = gender;
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

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailDto detailDto = (DetailDto) o;
        return Objects.equals(id, detailDto.id) && Objects.equals(homeAddress, detailDto.homeAddress) && Objects.equals(workAddress, detailDto.workAddress) && Objects.equals(nationalIdentity, detailDto.nationalIdentity) && Objects.equals(gender, detailDto.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, homeAddress, workAddress, nationalIdentity, gender);
    }

    @Override
    public String toString() {
        return "DetailDto{" +
                "id='" + id + '\'' +
                ", homeAddress=" + homeAddress +
                ", workAddress=" + workAddress +
                ", nationalIdentity='" + nationalIdentity + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
