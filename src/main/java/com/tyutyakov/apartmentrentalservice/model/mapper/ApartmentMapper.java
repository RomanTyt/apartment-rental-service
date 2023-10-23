package com.tyutyakov.apartmentrentalservice.model.mapper;

import com.tyutyakov.apartmentrentalservice.model.dto.ApartmentDTO;
import com.tyutyakov.apartmentrentalservice.model.entity.Apartment;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ApartmentMapper {
    Apartment apartmentDTOMapToApartment(ApartmentDTO apartmentDTO);

    ApartmentDTO apartmentMapToApartmentDTO(Apartment apartment);

    void updateApartment(ApartmentDTO apartmentDTO, @MappingTarget Apartment apartment);
}
