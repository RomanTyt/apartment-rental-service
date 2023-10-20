package com.tyutyakov.apartmentrentalservice.model.mapper;

import com.tyutyakov.apartmentrentalservice.model.dto.ApartmentCreateDTO;
import com.tyutyakov.apartmentrentalservice.model.dto.ApartmentGetDTO;
import com.tyutyakov.apartmentrentalservice.model.dto.ApartmentUpdateDTO;
import com.tyutyakov.apartmentrentalservice.model.entity.Apartment;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ApartmentMapper {
    Apartment apartmentDTOMapToApartment(ApartmentCreateDTO apartmentCreateDTO);

    ApartmentGetDTO apartmentMapToApartmentGetDTO(Apartment apartment);

    void updateApartment(ApartmentUpdateDTO apartmentUpdateDTO, @MappingTarget Apartment apartment);
}
