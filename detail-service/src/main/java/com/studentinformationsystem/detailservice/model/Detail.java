package com.studentinformationsystem.detailservice.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;

@Builder
@Entity
@Table(name = "details")
public class Detail {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "home_address_id")
    private Address homeAddress;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "work_address_id")
    private Address workAddress;




    public Detail() {
    }

    public Detail(String id,
                  Address homeAddress,
                  Address workAddress) {
        this.id = id;
        this.homeAddress = homeAddress;
        this.workAddress = workAddress;
    }

    public String getId() {
        return id;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detail detail = (Detail) o;
        return Objects.equals(id, detail.id) && Objects.equals(homeAddress, detail.homeAddress) && Objects.equals(workAddress, detail.workAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, homeAddress, workAddress);
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id='" + id + '\'' +
                ", homeAddress=" + homeAddress +
                ", workAddress=" + workAddress +
                '}';
    }

}
