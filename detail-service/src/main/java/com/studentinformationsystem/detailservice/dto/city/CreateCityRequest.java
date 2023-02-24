package com.studentinformationsystem.detailservice.dto.city;

import lombok.Builder;

import java.util.Objects;

@Builder
public class CreateCityRequest {
    private String name;
    private String plateNumber;

    public CreateCityRequest() {
    }

    public CreateCityRequest(String name, String plateNumber) {
        this.name = name;
        this.plateNumber = plateNumber;
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
        CreateCityRequest that = (CreateCityRequest) o;
        return Objects.equals(name, that.name) && Objects.equals(plateNumber, that.plateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, plateNumber);
    }

    @Override
    public String toString() {
        return "CreateCityRequest{" +
                "name='" + name + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }
}
