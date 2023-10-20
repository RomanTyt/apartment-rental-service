package com.tyutyakov.apartmentrentalservice.model.mapper;

import com.tyutyakov.apartmentrentalservice.model.dto.RulesOfAccommodationCreateDTO;
import com.tyutyakov.apartmentrentalservice.model.entity.RulesOfAccommodation;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface RulesOfAccommodationMapper {
    RulesOfAccommodation rulesOfAccommodationDTOMapToRulesOfAccommodation(RulesOfAccommodationCreateDTO rulesOfAccommodationCreateDTO);
}
