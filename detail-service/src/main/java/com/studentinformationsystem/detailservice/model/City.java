package com.studentinformationsystem.detailservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Objects;

@Builder
@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    private List<District> districts;

    @OneToMany(mappedBy = "city")
    private List<Address> addresses;

    private String name;

    private String plateNumber;


    public City() {
    }

    public City(String id, List<District> districts, List<Address> addresses, String name, String plateNumber) {
        this.id = id;
        this.districts = districts;
        this.addresses = addresses;
        this.name = name;
        this.plateNumber = plateNumber;
    }

    public String getId() {
        return id;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public List<Address> getAddresses() {
        return addresses;
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
        City city = (City) o;
        return Objects.equals(id, city.id) && Objects.equals(districts, city.districts) && Objects.equals(addresses, city.addresses) && Objects.equals(name, city.name) && Objects.equals(plateNumber, city.plateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, districts, addresses, name, plateNumber);
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", districts=" + districts +
                ", addresses=" + addresses +
                ", name='" + name + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }
}
