package com.tyutyakov.apartmentrentalservice.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ApartmentDTO {
    private short numberOfRooms;
    private float totalArea;
    private float kitchenArea;
    private short floor;
    private String bathroom;
    private String furniture;
    private String appliances;
    private String apartmentDescription;
}
