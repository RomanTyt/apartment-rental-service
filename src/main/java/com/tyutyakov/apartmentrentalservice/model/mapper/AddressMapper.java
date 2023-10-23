package com.tyutyakov.apartmentrentalservice.model.mapper;

import com.tyutyakov.apartmentrentalservice.model.dto.AddressDTO;
import com.tyutyakov.apartmentrentalservice.model.entity.Address;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AddressMapper {
    Address addressDTOMapToAddress(AddressDTO addressDTO);
}
