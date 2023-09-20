package com.tyutyakov.apartmentrentalservice.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ApartmentUpdateDTO {
    private int numberOfRooms;              // Количество комнат
    private double totalArea;               // Общая площадь
    private double kitchenArea;             // Площадь кухни
    private int floor;                      // Этаж
    private String bathroom;                // Санузел совмещённый/раздельный
    private String furniture;               // Мебель перечисление
    private String appliances;              // Бытовая техника перечисление
    private String apartmentDescription;    // Описание квартиры в свободной форме
}
