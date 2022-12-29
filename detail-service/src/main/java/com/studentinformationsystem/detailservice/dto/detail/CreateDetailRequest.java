package com.studentinformationsystem.detailservice.dto.detail;

import com.studentinformationsystem.detailservice.dto.address.CreateAddressRequest;

import java.util.Objects;

public class CreateDetailRequest {
    private CreateAddressRequest homeAddress;
    private CreateAddressRequest workAddress;

    public CreateAddressRequest getHomeAddress() {
        return homeAddress;
    }

    public CreateAddressRequest getWorkAddress() {
        return workAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateDetailRequest that = (CreateDetailRequest) o;
        return Objects.equals(homeAddress, that.homeAddress) && Objects.equals(workAddress, that.workAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeAddress, workAddress);
    }

    @Override
    public String toString() {
        return "CreateDetailRequest{" +
                "homeAddress=" + homeAddress +
                ", workAddress=" + workAddress +
                '}';
    }
}
