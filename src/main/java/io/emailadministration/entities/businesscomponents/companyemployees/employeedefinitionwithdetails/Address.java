package io.emailadministration.entities.businesscomponents.companyemployees.employeedefinitionwithdetails;

import io.emailadministration.Printing.CustomPrinting;
import io.emailadministration.customdatastructureandoperationsonthem.operationswithdatastructures.OperationsOnMap;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Getter
@Setter
@Embeddable
public class Address implements Comparable<Address> {

    @LazyGroup("ADDRESS_SPECIFIC")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "street")
    private String street;

    @LazyGroup("ADDRESS_SPECIFIC")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "number")
    private int number;

    @LazyGroup("ADDRESS_SPECIFIC")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "apartment")
    private int apartment;

    @LazyGroup("ADDRESS_WIDE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "city")
    private String city;

    @LazyGroup("ADDRESS_WIDE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "country")
    private String country;

    @LazyGroup("ADDRESS_SPECIFIC")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "zipcode")
    private int zipcode;

    public Address() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;


        if ((address.number != number) || (address.apartment != apartment) || (address.zipcode != zipcode) ||
                (!address.street.equals(street)) || (!address.city.equals(city))) {
            return false;
        }

        return address.country.equals(country);
    }

    @Override
    public int hashCode() {
        int result = street.hashCode();

        result = 31 * result + number;
        result = 31 * result + apartment;
        result = 31 * result + city.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + zipcode;

        return result;
    }

    @Override
    public int compareTo(@NotNull Address o) {
        return Integer.compare(this.zipcode, o.zipcode);
    }

    @Override
    public String toString() {
        Map<String, ?> characteristics = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(characteristics, "Address [");
    }
}
