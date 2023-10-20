package com.tyutyakov.apartmentrentalservice.model.dto;

import com.tyutyakov.apartmentrentalservice.model.entity.Address;
import com.tyutyakov.apartmentrentalservice.model.entity.RulesOfAccommodation;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ApartmentGetDTO {
    private int numberOfRooms;              // Количество комнат
    private double totalArea;               // Общая площадь
    private double kitchenArea;             // Площадь кухни
    private int floor;                      // Этаж
    private String bathroom;                // Санузел совмещённый/раздельный
    private String furniture;               // Мебель перечисление
    private String appliances;              // Бытовая техника перечисление
    private String apartmentDescription;    // Описание квартиры в свободной форме
}
