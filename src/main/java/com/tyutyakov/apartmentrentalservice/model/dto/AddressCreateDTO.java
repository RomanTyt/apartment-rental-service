package com.tyutyakov.apartmentrentalservice.model.dto;

import com.tyutyakov.apartmentrentalservice.model.entity.Address;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
public class AddressCreateDTO {
    private String city;
    private String street;
    private String houseNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressCreateDTO that = (AddressCreateDTO) o;

        if (!city.equals(that.city)) return false;
        if (!street.equals(that.street)) return false;
        return houseNumber.equals(that.houseNumber);
    }

    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + houseNumber.hashCode();
        return result;
    }
}
