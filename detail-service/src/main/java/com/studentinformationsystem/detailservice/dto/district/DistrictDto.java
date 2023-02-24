package com.studentinformationsystem.detailservice.dto.district;

import lombok.Builder;

import java.util.Objects;

@Builder
public class DistrictDto {
    private String id;
    private String name;
    private String cityName;

    public DistrictDto() {
    }

    public DistrictDto(String id, String name, String cityName) {
        this.id = id;
        this.name = name;
        this.cityName = cityName;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistrictDto that = (DistrictDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(cityName, that.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cityName);
    }

    @Override
    public String toString() {
        return "DistrictDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
