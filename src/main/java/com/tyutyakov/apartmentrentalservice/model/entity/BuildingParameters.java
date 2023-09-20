package com.tyutyakov.apartmentrentalservice.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "building_parameters")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BuildingParameters {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "building_id")
    private UUID buildingId;
    private String houseType;                   // Тип дома: монолитный / кирпичный и тд
    private int yearOfConstruction;             // Год постройки
    private int floorsInTheHouse;               // Этажей в доме
    private int passengerElevatorQuantity ;     // Пассажирский лифт количество
    private int freightElevatorQuantity ;       // Грузовой лифт количество
    private String parkingSpace;                // Парковка описание

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
