package com.tyutyakov.apartmentrentalservice.controller;

import com.tyutyakov.apartmentrentalservice.model.dto.*;
import com.tyutyakov.apartmentrentalservice.model.entity.Apartment;
import com.tyutyakov.apartmentrentalservice.service.ApartmentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "api/v1/apartments", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApartmentController {
    private final ApartmentService service;

    public ApartmentController(ApartmentService service){
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Добавить квартиру")
    public Apartment addApartment(@RequestBody ApartmentDTO apartmentDTO){
        return service.addApartment(apartmentDTO);
    }

    @GetMapping("/{apartmentId}")
    @Operation(summary = "Получить квартиру по id")
    public ApartmentDTO getApartment(@PathVariable UUID apartmentId){
        return service.getApartment(apartmentId);
    }

    @PatchMapping("/{apartmentId}")
    @Operation(summary = "Изменить квартиру по id")
    public ApartmentDTO updateApartment(ApartmentDTO apartmentDTO, @PathVariable UUID apartmentId){
        return service.updateApartment(apartmentDTO, apartmentId);
    }

    @DeleteMapping("/{apartmentId}")
    @Operation(summary = "Удалить квартиру по id")
    public String deleteApartment(@PathVariable UUID apartmentId){
        return service.deleteApartment(apartmentId);
    }

    @PostMapping("/{apartmentId}/rulesOfAccommodation")
    @Operation(summary = "Добавить правила проживания")
    public String addRulesOfAccommodation(RulesOfAccommodationDTO rulesOfAccommodationDTO, @PathVariable UUID apartmentId){
        return service.addRulesOfAccommodation(rulesOfAccommodationDTO, apartmentId);
    }

    @PostMapping("/{addressId}/buildingParameters")
    @Operation(summary = "Добавить параметры здания")
    public String addBuildingParameters(BuildingParametersDTO buildingParametersDTO, @PathVariable UUID addressId){
        return service.addBuildingParameters(buildingParametersDTO, addressId);
    }

    @PostMapping("/{apartmentId}/addAddress")
    @Operation(summary = "Добавить адрес по id квартиры")
    public String addAddress(AddressDTO addressDTO, @PathVariable UUID apartmentId){
        return service.addAddress(addressDTO, apartmentId);
    }
}
