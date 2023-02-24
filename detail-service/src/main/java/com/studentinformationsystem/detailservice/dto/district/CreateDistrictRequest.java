package com.studentinformationsystem.detailservice.dto.district;

import lombok.Builder;

import java.util.Objects;
@Builder
public class CreateDistrictRequest {
    private String name;
    private String cityId;

    public CreateDistrictRequest() {
    }

    public CreateDistrictRequest(String name, String cityId) {
        this.name = name;
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public String getCityId() {
        return cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateDistrictRequest request = (CreateDistrictRequest) o;
        return Objects.equals(name, request.name) && Objects.equals(cityId, request.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cityId);
    }

    @Override
    public String toString() {
        return "CreateDistrictRequest{" +
                "name='" + name + '\'' +
                ", cityId='" + cityId + '\'' +
                '}';
    }
}
