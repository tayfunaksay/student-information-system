package com.studentinformationsystem.registrarservice.model;

import jakarta.persistence.*;
import lombok.Builder;

@Builder
@Entity
@Table(name = "districts")
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id",nullable = false)
    private City city;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "district")
    private Address address;

    private String name;


    public District() {
    }

    public District(long id, City city, Address address, String name) {
        this.id = id;
        this.city = city;
        this.address = address;
        this.name = name;
    }



    public long getId() {
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
