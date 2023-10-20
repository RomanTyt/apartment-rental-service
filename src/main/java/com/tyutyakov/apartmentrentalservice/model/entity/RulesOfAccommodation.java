package com.tyutyakov.apartmentrentalservice.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "rules_of_accommodation")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RulesOfAccommodation {         // Правила проживания
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "rules_of_accommodation_id")
    private UUID rulesOfAccommodationId;
    private int numberOfGuests;                 // Количество гостей
    private boolean possibleWithChildren;       // Можно с детьми
    private boolean possibleWithAnimals;        // Можно с животными
    private boolean canSmoke;                   // Можно курить

    @OneToOne(mappedBy = "rulesOfAccommodation")
    private Apartment apartment;
}
