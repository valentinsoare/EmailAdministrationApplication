package io.emailadministration.entities.businesscomponents.companyemployees.employeedefinitionwithdetails;

import io.emailadministration.Printing.CustomPrinting;
import io.emailadministration.customdatastructureandoperationsonthem.operationswithdatastructures.OperationsOnMap;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyGroup;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

@Getter
@Setter
@Embeddable
public class TimeAndDateInformation {
    @LazyGroup("FIRST_WAVE_TIME_AND_DATE")
    @Column(name = "hire_date")
    @Basic(fetch = FetchType.LAZY)
    private LocalDate hireDate;

    @LazyGroup("FIRST_WAVE_TIME_AND_DATE")
    @Column(name = "creation_profile_date")
    @Basic(fetch = FetchType.LAZY)
    private LocalDate creationProfileDate;

    @LazyGroup("FIRST_WAVE_TIME_AND_DATE")
    @Column(name = "last_modification_on_profile_date")
    @Basic(fetch = FetchType.LAZY)
    private LocalDate lastModificationOnProfileDate;


    @LazyGroup("SECOND_WAVE_TIME_AND_DATE")
    @Column(name = "creation_profile_time")
    @Basic(fetch = FetchType.LAZY)
    private LocalTime creationProfileTime;

    @LazyGroup("SECOND_WAVE_TIME_AND_DATE")
    @Column(name = "last_modification_on_profile_time")
    @Basic(fetch = FetchType.LAZY)
    private LocalTime lastModificationOnProfileTime;


    @Transient
    @LazyGroup("THIRD_WAVE_TIME_AND_DATE")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal numberOfDaysFromHiring;

    @Transient
    @LazyGroup("THIRD_WAVE_TIME_AND_DATE")
    @Basic(fetch = FetchType.LAZY)
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
