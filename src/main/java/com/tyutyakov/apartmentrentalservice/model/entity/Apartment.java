package com.tyutyakov.apartmentrentalservice.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "apartment")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "apartment_id")
    private UUID apartmentId;
    private int numberOfRooms;              // Количество комнат
    private double totalArea;               // Общая площадь
    private double kitchenArea;             // Площадь кухни
    private int floor;                      // Этаж
    private String bathroom;                // Санузел совмещённый/раздельный
    private String furniture;               // Мебель перечисление
    private String appliances;              // Бытовая техника перечисление
    private String apartmentDescription;    // Описание квартиры в свободной форме

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rules_Of_Accommodation_id")
    private RulesOfAccommodation rulesOfAccommodation;
}
