package com.studentinformationsystem.detailservice.dto.city;

import lombok.Builder;

import java.util.Objects;

@Builder
public class CityDto {
    private String id;
    private String name;
    private String plateNumber;

    public CityDto() {
    }

    public CityDto(String id, String name, String plateNumber) {
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
        CityDto cityDto = (CityDto) o;
        return Objects.equals(id, cityDto.id) && Objects.equals(name, cityDto.name) && Objects.equals(plateNumber, cityDto.plateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, plateNumber);
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }
}
