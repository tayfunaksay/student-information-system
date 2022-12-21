package com.studentinformationsystem.registrarservice.dto.district;

import lombok.Builder;

import java.util.Objects;

@Builder
public class DistrictDto {
    private String id;
    private String name;

    public DistrictDto() {
    }

    public DistrictDto(String id,String name) {
        this.id=id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistrictDto that = (DistrictDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "DistrictDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
