package com.tyutyakov.apartmentrentalservice.model.mapper;

import com.tyutyakov.apartmentrentalservice.model.dto.BuildingParametersCreateDTO;
import com.tyutyakov.apartmentrentalservice.model.entity.BuildingParameters;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BuildingParametersMapper {
    BuildingParameters buildingParametersDTOMapToBuildingParameters(BuildingParametersCreateDTO buildingParametersCreateDTO);
}
