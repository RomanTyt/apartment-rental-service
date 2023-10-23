package com.tyutyakov.apartmentrentalservice.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ADDRESS")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ADDRESS_ID")
    private UUID addressId;
    private String oblast;
    private String city;
    private String street;
    private String houseNumber;
    private int hashCode;

    @OneToMany(mappedBy = "address")
    private List<Apartment> apartmentList;

    @OneToOne(mappedBy = "address")
    private BuildingParameters buildingParameters;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!oblast.equals(address.oblast)) return false;
        if (!city.equals(address.city)) return false;
        if (!street.equals(address.street)) return false;
        return houseNumber.equals(address.houseNumber);
    }

    @Override
    public int hashCode() {
        int result = oblast.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + houseNumber.hashCode();
        return result;
    }
}