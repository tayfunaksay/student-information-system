package com.studentinformationsystem.registrarservice.model;

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

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "detail")
    private Student student;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "detail")
    private Instructor instructor;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "detail")
    private Staff staff;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "home_address_id")
    private Address homeAddress;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "work_address_id")
    private Address workAddress;

    private String nationalIdentity;
    private String gender;


    public Detail() {
    }

    public Detail(String id, Student student, Instructor instructor, Staff staff, Address homeAddress, Address workAddress, String nationalIdentity, String gender) {
        this.id = id;
        this.student = student;
        this.instructor = instructor;
        this.staff = staff;
        this.homeAddress = homeAddress;
        this.workAddress = workAddress;
        this.nationalIdentity = nationalIdentity;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public Staff getStaff() {
        return staff;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public Address getWorkAddress() {
        return workAddress;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detail detail = (Detail) o;
        return Objects.equals(id, detail.id) && Objects.equals(student, detail.student) && Objects.equals(instructor, detail.instructor) && Objects.equals(staff, detail.staff) && Objects.equals(homeAddress, detail.homeAddress) && Objects.equals(workAddress, detail.workAddress) && Objects.equals(nationalIdentity, detail.nationalIdentity) && Objects.equals(gender, detail.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, instructor, staff, homeAddress, workAddress, nationalIdentity, gender);
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id='" + id + '\'' +
                ", student=" + student +
                ", instructor=" + instructor +
                ", staff=" + staff +
                ", homeAddress=" + homeAddress +
                ", workAddress=" + workAddress +
                ", nationalIdentity='" + nationalIdentity + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
