package com.tyutyakov.apartmentrentalservice.service;

import com.tyutyakov.apartmentrentalservice.model.dto.*;
import com.tyutyakov.apartmentrentalservice.model.entity.Address;
import com.tyutyakov.apartmentrentalservice.model.entity.Apartment;
import com.tyutyakov.apartmentrentalservice.model.entity.BuildingParameters;
import com.tyutyakov.apartmentrentalservice.model.entity.RulesOfAccommodation;
import com.tyutyakov.apartmentrentalservice.model.mapper.AddressMapper;
import com.tyutyakov.apartmentrentalservice.model.mapper.ApartmentMapper;
import com.tyutyakov.apartmentrentalservice.model.mapper.BuildingParametersMapper;
import com.tyutyakov.apartmentrentalservice.model.mapper.RulesOfAccommodationMapper;
import com.tyutyakov.apartmentrentalservice.repository.AddressRepository;
import com.tyutyakov.apartmentrentalservice.repository.ApartmentRepository;
import com.tyutyakov.apartmentrentalservice.repository.BuildingParametersRepository;
import com.tyutyakov.apartmentrentalservice.repository.RulesOfAccommodationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;
    private final RulesOfAccommodationRepository rulesOfAccommodationRepository;
    private final BuildingParametersRepository buildingParametersRepository;
    private final AddressRepository addressRepository;
    private final ApartmentMapper apartmentMapper;
    private final RulesOfAccommodationMapper rulesOfAccommodationMapper;
    private final BuildingParametersMapper buildingParametersMapper;
    private final AddressMapper addressMapper;

    public ApartmentService(ApartmentRepository apartmentRepository, RulesOfAccommodationRepository rulesOfAccommodationRepository, BuildingParametersRepository buildingParametersRepository, AddressRepository addressRepository, ApartmentMapper apartmentMapper, RulesOfAccommodationMapper rulesOfAccommodationMapper, BuildingParametersMapper buildingParametersMapper, AddressMapper addressMapper){
        this.apartmentRepository = apartmentRepository;
        this.rulesOfAccommodationRepository = rulesOfAccommodationRepository;
        this.buildingParametersRepository = buildingParametersRepository;
        this.addressRepository = addressRepository;
        this.apartmentMapper = apartmentMapper;
        this.rulesOfAccommodationMapper = rulesOfAccommodationMapper;
        this.buildingParametersMapper = buildingParametersMapper;
        this.addressMapper = addressMapper;
    }

    public Apartment addApartment(ApartmentCreateDTO apartmentCreateDTO){
        return apartmentRepository.save(apartmentMapper.apartmentDTOMapToApartment(apartmentCreateDTO));
    }

    public ApartmentGetDTO getApartment(UUID apartmentId){
        Apartment apartment = apartmentRepository.findById(apartmentId).orElseThrow();
        return apartmentMapper.apartmentMapToApartmentGetDTO(apartment);
    }

    public ApartmentGetDTO updateApartment(ApartmentUpdateDTO apartmentUpdateDTO, UUID apartmentId){
        Apartment apartment = apartmentRepository.findById(apartmentId).orElseThrow();
        apartmentMapper.updateApartment(apartmentUpdateDTO, apartment);
        Apartment save = apartmentRepository.save(apartment);
        return apartmentMapper.apartmentMapToApartmentGetDTO(save);
    }

    public String deleteApartment(UUID apartmentId){
        apartmentRepository.findById(apartmentId).orElseThrow();
        apartmentRepository.deleteById(apartmentId);
        if (apartmentRepository.existsById(apartmentId)){
            return "Квартира НЕ удалена";
        }
        return "Квартира удалена";
    }

    public String addRulesOfAccommodation(RulesOfAccommodationCreateDTO rulesOfAccommodationCreateDTO, UUID apartmentId){
        RulesOfAccommodation rulesOfAccommodation = rulesOfAccommodationMapper.rulesOfAccommodationDTOMapToRulesOfAccommodation(rulesOfAccommodationCreateDTO);
        Apartment apartment = apartmentRepository.findById(apartmentId).orElseThrow();
        if (apartment.getRulesOfAccommodation() != null){
            return "Правила проживания для этой квартиры уже есть в БД";
        }
        apartment.setRulesOfAccommodation(rulesOfAccommodation);
        return "Правила проживания для этой квартиры добавлены в БД. Id: " + rulesOfAccommodationRepository.save(rulesOfAccommodation).getRulesOfAccommodationId().toString();
    }

    public String addBuildingParameters(BuildingParametersCreateDTO buildingParametersCreateDTO, UUID addressId){
        Address address = addressRepository.findById(addressId).orElseThrow();
        if (address.getBuildingParameters() != null){
            return "Параметры этого здания уже есть в БД";
        }
        BuildingParameters buildingParameters = buildingParametersMapper.buildingParametersDTOMapToBuildingParameters(buildingParametersCreateDTO);
        buildingParameters.setAddress(address);
        return "Параметры здания добавлены в БД. Id: " + buildingParametersRepository.save(buildingParameters).getBuildingId().toString();
    }

    public String addAddress(AddressCreateDTO addressCreateDTO, UUID apartmentId){
        Apartment apartment = apartmentRepository.findById(apartmentId).orElseThrow();
        if (apartment.getAddress() != null) {
            return "У этой квартиры уже есть адрес";
        }
        if (addressRepository.existsByHashCode(addressCreateDTO.hashCode())){
            Address byHashCode = addressRepository.findByHashCode(addressCreateDTO.hashCode());
            apartment.setAddress(byHashCode);
            return "Адрес присвоен квартире, но он уже был в БД. Id: " + byHashCode.getAddressId().toString();
        }
        Address address = addressMapper.addressDTOMapToAddress(addressCreateDTO);
        address.setHashCode(address.hashCode());
        apartment.setAddress(address);
        return "Новый адрес добавлен в БД и присвоен квартире. Id: " + addressRepository.save(address).getAddressId().toString();
    }
}