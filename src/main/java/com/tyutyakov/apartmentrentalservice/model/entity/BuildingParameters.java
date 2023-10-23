package com.tyutyakov.apartmentrentalservice.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "BUILDING_PARAMETERS")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BuildingParameters {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "BUILDING_ID")
    private UUID buildingId;
    private String houseType;                   // Тип дома: монолитный / кирпичный и тд
    private short yearOfConstruction;           // Год постройки
    private short floorsInTheHouse;             // Этажей в доме
    private short passengerElevatorQuantity;    // Пассажирский лифт количество
    private short freightElevatorQuantity ;     // Грузовой лифт количество
    private String parkingSpace;                // Парковка описание

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;
}
