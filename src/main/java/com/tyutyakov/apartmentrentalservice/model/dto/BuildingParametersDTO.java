package com.tyutyakov.apartmentrentalservice.model.dto;

import lombok.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BuildingParametersDTO {
    private String houseType;
    private short yearOfConstruction;
    private short floorsInTheHouse;
    private short passengerElevatorQuantity;
    private short freightElevatorQuantity ;
    private String parkingSpace;
}