package com.tyutyakov.apartmentrentalservice.repository;

import com.tyutyakov.apartmentrentalservice.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<Address, UUID> {
    Address findByHashCode(int hashCode);

    boolean existsByHashCode(int hashCode);
}
