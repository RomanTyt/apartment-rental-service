package com.tyutyakov.apartmentrentalservice.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "APARTMENT")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "APARTMENT_ID")
    private UUID apartmentId;
    private short numberOfRooms;            // Количество комнат
    private float totalArea;                // Общая площадь
    private float kitchenArea;              // Площадь кухни
    private short floor;                    // Этаж
    private String bathroom;                // Санузел совмещённый/раздельный
    private String furniture;               // Мебель перечисление
    private String appliances;              // Бытовая техника перечисление
    private String apartmentDescription;    // Описание квартиры в свободной форме

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RULES_OF_ACCOMMODATION_ID")
    private RulesOfAccommodation rulesOfAccommodation;
}
