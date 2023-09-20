package com.tyutyakov.apartmentrentalservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RulesOfAccommodationCreateDTO {
    private int numberOfGuests;                 // Количество гостей
    private boolean possibleWithChildren;       // Можно с детьми
    private boolean possibleWithAnimals;        // Можно с животными
    private boolean canSmoke;                   // Можно курить
}
