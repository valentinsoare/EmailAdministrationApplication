package io.emailadministration.entities.companyemployees.employeedefinitionwithdetails;

import io.emailadministration.printing.CustomPrinting;
import io.emailadministration.customdatastructureandoperationsonthem.operationswithdatastructures.OperationsOnMap;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Getter
@Setter
@Embeddable
public class Address implements Comparable<Address> {
    @Column(name = "street", nullable = false, columnDefinition = "varchar(125) default 'none'")
    private String street;

    @Column(name = "number", nullable = false, columnDefinition = "int default -1")
    private int number;

    @Column(name = "apartment", columnDefinition = "int default -1")
    private int apartment;

    @Column(name = "city", nullable = false, columnDefinition = "varchar(125) default 'none'")
    private String city;

    @Column(name = "country", nullable = false, columnDefinition = "varchar(125) default 'none'")
    private String country;

    @Column(name = "zipcode", nullable = false, columnDefinition = "int default -1")
    private int zipcode;

    public Address() {}

    public Address(Address address) {
        this.street = new String(address.getStreet());
        this.number = address.getNumber();
        this.apartment = address.getApartment();
        this.city = new String(address.getCity());
        this.country = new String(address.getCountry());
        this.zipcode = address.getZipcode();
    }

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
