package com.studentinformationsystem.detailservice.dto.detail;

import com.studentinformationsystem.detailservice.dto.address.UpdateAddressRequest;

import java.util.Objects;

public class UpdateDetailRequest {
    private String id;
    private UpdateAddressRequest homeAddress;
    private UpdateAddressRequest workAddress;

    public String getId() {
        return id;
    }

    public UpdateAddressRequest getHomeAddress() {
        return homeAddress;
    }

    public UpdateAddressRequest getWorkAddress() {
        return workAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateDetailRequest that = (UpdateDetailRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(homeAddress, that.homeAddress) && Objects.equals(workAddress, that.workAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, homeAddress, workAddress);
    }

    @Override
    public String toString() {
        return "UpdateDetailRequest{" +
                "id='" + id + '\'' +
                ", homeAddress=" + homeAddress +
                ", workAddress=" + workAddress +
                '}';
    }
}
