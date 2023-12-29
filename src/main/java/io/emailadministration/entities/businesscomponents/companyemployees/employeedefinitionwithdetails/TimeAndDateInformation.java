package io.emailadministration.entities.businesscomponents.companyemployees.employeedefinitionwithdetails;

import io.emailadministration.printing.CustomPrinting;
import io.emailadministration.customdatastructureandoperationsonthem.operationswithdatastructures.OperationsOnMap;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

@Getter
@Setter
@Embeddable
public class TimeAndDateInformation {
    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "creation_profile_date")
    private LocalDate creationProfileDate;

    @Column(name = "last_modification_on_profile_date")
    private LocalDate lastModificationOnProfileDate;

    @Column(name = "creation_profile_time")
    private LocalTime creationProfileTime;

    @Column(name = "last_modification_on_profile_time")
    private LocalTime lastModificationOnProfileTime;

    @Transient
    private BigDecimal numberOfDaysFromHiring;

    @Transient
    private BigDecimal numberOfDaysFromLastModification;


    public TimeAndDateInformation() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeAndDateInformation that)) return false;

        if ((!that.hireDate.equals(hireDate)) || (!that.creationProfileDate.equals(creationProfileDate))) {
            return false;
        }

        return (that.lastModificationOnProfileDate.equals(lastModificationOnProfileDate));
    }

    @Override
    public int hashCode() {
        int result = hireDate.hashCode();

        result = 31 * result + creationProfileDate.hashCode();
        result = 31 * result + lastModificationOnProfileDate.hashCode();
        result = 31 * result + creationProfileTime.hashCode();
        result = 31 * result + lastModificationOnProfileTime.hashCode();

        return result;
    }

    @Override
    public String toString() {
        Map<String, ?> characteristics = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(characteristics, "TimeAndDateInformation [");
    }
}
