package com.tyutyakov.apartmentrentalservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RulesOfAccommodationDTO {
    private short numberOfGuests;
    private boolean possibleWithChildren;
    private boolean possibleWithAnimals;
    private boolean canSmoke;
}
