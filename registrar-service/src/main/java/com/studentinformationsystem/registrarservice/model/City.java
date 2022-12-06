package com.studentinformationsystem.registrarservice.model;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;
import java.util.Objects;

@Builder
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private short id;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "city",cascade = CascadeType.ALL)
    private List<District> districts;

    @OneToOne(mappedBy = "city")
    private Address address;

    private String name;

    private short plateNumber;


    public City() {
    }

    public City(short id, List<District> districts, Address address, String name, short plateNumber) {
        this.id = id;
        this.districts = districts;
        this.address = address;
        this.name = name;
        this.plateNumber = plateNumber;
    }

    public long getId() {
        return id;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public short getPlateNumber() {
        return plateNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id && plateNumber == city.plateNumber && Objects.equals(districts, city.districts) && Objects.equals(address, city.address) && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, districts, address, name, plateNumber);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", districts=" + districts +
                ", address=" + address +
                ", name='" + name + '\'' +
                ", plateNumber=" + plateNumber +
                '}';
    }
}
