package com.studentinformationsystem.detailservice.dto.detail;

import lombok.Builder;

import java.util.Objects;

@Builder
public class CreateDefaultDetailRequest {
    private String cityId;
    private String districtId;

    public CreateDefaultDetailRequest() {
    }

    public CreateDefaultDetailRequest(String cityId, String districtId) {
        this.cityId = cityId;
        this.districtId = districtId;
    }

    public String getCityId() {
        return cityId;
    }

    public String getDistrictId() {
        return districtId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateDefaultDetailRequest that = (CreateDefaultDetailRequest) o;
        return Objects.equals(cityId, that.cityId) && Objects.equals(districtId, that.districtId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, districtId);
    }

    @Override
    public String toString() {
        return "CreateDetailRequest{" +
                "cityId='" + cityId + '\'' +
                ", districtId='" + districtId + '\'' +
                '}';
    }
}
