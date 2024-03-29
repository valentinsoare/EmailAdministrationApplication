package io.emailadministration.entities.companyemployees.employeedefinitionwithdetails;

import io.emailadministration.devcomponents.Component;
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
public class TimeAndDateInformation implements Component<TimeAndDateInformation> {
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

    public TimeAndDateInformation(TimeAndDateInformation timeAndDate) {
        this.hireDate = LocalDate.from(timeAndDate.getHireDate());

        this.creationProfileDate = LocalDate.from(timeAndDate.getCreationProfileDate());
        this.lastModificationOnProfileDate = LocalDate.from(timeAndDate.getLastModificationOnProfileDate());

        this.creationProfileTime = LocalTime.from(timeAndDate.getCreationProfileTime());
        this.lastModificationOnProfileTime = LocalTime.from(timeAndDate.getLastModificationOnProfileTime());

        this.numberOfDaysFromHiring =
                new BigDecimal(String.valueOf(timeAndDate.getNumberOfDaysFromHiring()));
        this.numberOfDaysFromLastModification =
                new BigDecimal(String.valueOf(timeAndDate.getNumberOfDaysFromLastModification()));
    }

    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    @Override
    public TimeAndDateInformation getPresentObject() {
        return this;
    }

    public TimeAndDateInformation getCopyInstance(TimeAndDateInformation timeAndDateInformation) {
        return new TimeAndDateInformation(timeAndDateInformation);
    }

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
