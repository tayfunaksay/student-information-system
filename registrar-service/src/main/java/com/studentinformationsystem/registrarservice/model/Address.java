package com.studentinformationsystem.registrarservice.model;


import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

@Builder
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id", nullable = false)
    private Detail detail;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id",nullable = false)
    private City city;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "district_id",nullable = false)
    private District district;

    private AddressType addressType;

    private String postCode;

    private String street;


    public Address() {
    }

    public Address(String id, Detail detail, City city, District district, AddressType addressType, String postCode, String street) {
        this.id = id;
        this.detail = detail;
        this.city = city;
        this.district = district;
        this.addressType = addressType;
        this.postCode = postCode;
        this.street = street;
    }


    public String getId() {
        return id;
    }

    public Detail getDetail() {
        return detail;
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
}
