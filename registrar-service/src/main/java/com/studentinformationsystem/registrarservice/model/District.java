package com.studentinformationsystem.registrarservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

@Builder
@Entity
@Table(name = "districts")
public class District {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id",nullable = false)
    private City city;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "district")
    private Address address;

    private String name;


    public District() {
    }

    public District(String id, City city, Address address, String name) {
        this.id = id;
        this.city = city;
        this.address = address;
        this.name = name;
    }



    public String getId() {
        return id;
    }

    public City getCity() {
        return city;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }
}
