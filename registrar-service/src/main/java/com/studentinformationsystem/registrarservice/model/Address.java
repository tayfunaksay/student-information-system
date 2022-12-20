package com.studentinformationsystem.registrarservice.model;


import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Builder
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "homeAddress")
    private Detail detailHome;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "workAddress")
    private Detail detailWork;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private District district;

    private AddressType addressType;

    private String postCode;

    private String street;


    public Address() {
    }

    public Address(String id, Detail detailHome, Detail detailWork, City city, District district, AddressType addressType, String postCode, String street) {
        this.id = id;
        this.detailHome = detailHome;
        this.detailWork = detailWork;
        this.city = city;
        this.district = district;
        this.addressType = addressType;
        this.postCode = postCode;
        this.street = street;
    }

    public String getId() {
        return id;
    }

    public Detail getDetailHome() {
        return detailHome;
    }

    public Detail getDetailWork() {
        return detailWork;
    }

    public City getCity() {
        return city;
    }

    public District getDistrict() {
        return district;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(detailHome, address.detailHome) && Objects.equals(detailWork, address.detailWork) && Objects.equals(city, address.city) && Objects.equals(district, address.district) && addressType == address.addressType && Objects.equals(postCode, address.postCode) && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, detailHome, detailWork, city, district, addressType, postCode, street);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", detailHome=" + detailHome +
                ", detailWork=" + detailWork +
                ", city=" + city +
                ", district=" + district +
                ", addressType=" + addressType +
                ", postCode='" + postCode + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
