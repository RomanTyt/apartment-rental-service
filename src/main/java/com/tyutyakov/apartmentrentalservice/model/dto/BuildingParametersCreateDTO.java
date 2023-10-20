package com.tyutyakov.apartmentrentalservice.model.dto;

import lombok.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BuildingParametersCreateDTO {
    private String houseType;                   // Тип дома: монолитный / кирпичный и тд
    private int yearOfConstruction;             // Год постройки
    private int floorsInTheHouse;               // Этажей в доме
    private int passengerElevatorQuantity ;     // Пассажирский лифт количество
    private int freightElevatorQuantity ;       // Грузовой лифт количество
    private String parkingSpace;                // Парковка описание
}
