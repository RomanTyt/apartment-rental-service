package com.tyutyakov.apartmentrentalservice.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "RULES_OF_ACCOMMODATION")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RulesOfAccommodation {                     // Правила проживания
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "RULES_OF_ACCOMMODATION_ID")
    private UUID rulesOfAccommodationId;
    private short numberOfGuests;                       // Количество гостей
    private boolean possibleWithChildren;               // Можно с детьми
    private boolean possibleWithAnimals;                // Можно с животными
    private boolean canSmoke;                           // Можно курить

    @OneToOne(mappedBy = "rulesOfAccommodation")
    private Apartment apartment;
}
