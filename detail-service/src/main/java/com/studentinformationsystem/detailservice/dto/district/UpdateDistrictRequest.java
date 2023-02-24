package com.studentinformationsystem.detailservice.dto.district;

import lombok.Builder;

import java.util.Objects;
@Builder
public class UpdateDistrictRequest {
    private String id;
    private String name;
    private String cityId;

    public UpdateDistrictRequest() {
    }

    public UpdateDistrictRequest(String id, String name, String cityId) {
        this.id = id;
        this.name = name;
        this.cityId = cityId;
    }

    public String getId() {
        return id;
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
        UpdateDistrictRequest that = (UpdateDistrictRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(cityId, that.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cityId);
    }

    @Override
    public String toString() {
        return "UpdateDistrictRequest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cityId='" + cityId + '\'' +
                '}';
    }
}
