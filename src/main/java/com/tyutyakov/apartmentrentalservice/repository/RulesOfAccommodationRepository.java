package com.tyutyakov.apartmentrentalservice.repository;

import com.tyutyakov.apartmentrentalservice.model.entity.RulesOfAccommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RulesOfAccommodationRepository extends JpaRepository<RulesOfAccommodation, UUID> {
}
