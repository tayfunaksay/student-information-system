package com.studentinformationsystem.detailservice.dto.city;

import lombok.Builder;

import java.util.Objects;

@Builder
public class UpdateCityRequest {
    private String id;
    private String name;
    private String plateNumber;

    public UpdateCityRequest() {
    }

    public UpdateCityRequest(String id, String name, String plateNumber) {
        this.id = id;
        this.name = name;
        this.plateNumber = plateNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateCityRequest that = (UpdateCityRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(plateNumber, that.plateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, plateNumber);
    }

    @Override
    public String toString() {
        return "UpdateCityRequest{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }
}
