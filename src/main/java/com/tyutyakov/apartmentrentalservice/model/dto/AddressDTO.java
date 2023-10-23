package com.tyutyakov.apartmentrentalservice.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private String oblast;
    private String city;
    private String street;
    private String houseNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressDTO that = (AddressDTO) o;

        if (!oblast.equals(that.oblast)) return false;
        if (!city.equals(that.city)) return false;
        if (!street.equals(that.street)) return false;
        return houseNumber.equals(that.houseNumber);
    }

    @Override
    public int hashCode() {
        int result = oblast.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + houseNumber.hashCode();
        return result;
    }
}
