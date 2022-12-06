package com.studentinformationsystem.registrarservice.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "details")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;


    @OneToOne(fetch = FetchType.LAZY, mappedBy = "detail")
    private Student student;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "detail")
    private Instructor instructor;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "detail")
    private Staff staff;

    @OneToMany(mappedBy = "detail", cascade = CascadeType.ALL)
    private List<Address> addresses;

    private String nationalIdentity;
    private String gender;


    public Detail() {
    }

    public Detail(Long id, Student student, Instructor instructor, Staff staff, List<Address> addresses, String nationalIdentity, String gender) {
        this.id = id;
        this.student = student;
        this.instructor = instructor;
        this.staff = staff;
        this.addresses = addresses;
        this.nationalIdentity = nationalIdentity;
        this.gender = gender;
    }



    public Long getId() {
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

    public List<Address> getAddresses() {
        return addresses;
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
        return Objects.equals(id, detail.id) && Objects.equals(student, detail.student) && Objects.equals(instructor, detail.instructor) && Objects.equals(staff, detail.staff) && Objects.equals(addresses, detail.addresses) && Objects.equals(nationalIdentity, detail.nationalIdentity) && Objects.equals(gender, detail.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, instructor, staff, addresses, nationalIdentity, gender);
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", student=" + student +
                ", instructor=" + instructor +
                ", staff=" + staff +
                ", addresses=" + addresses +
                ", nationalIdentity='" + nationalIdentity + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
