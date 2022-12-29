package com.studentinformationsystem.detailservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Objects;

@Builder
@Entity
@Table(name = "districts")
public class District {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "district")
    private List<Address> addresses;

    private String name;


    public District() {
    }

    public District(String id, City city, List<Address> addresses, String name) {
        this.id = id;
        this.city = city;
        this.addresses = addresses;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public City getCity() {
        return city;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return Objects.equals(id, district.id) && Objects.equals(city, district.city) && Objects.equals(addresses, district.addresses) && Objects.equals(name, district.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, addresses, name);
    }

    @Override
    public String toString() {
        return "District{" +
                "id='" + id + '\'' +
                ", city=" + city +
                ", addresses=" + addresses +
                ", name='" + name + '\'' +
                '}';
    }
}
