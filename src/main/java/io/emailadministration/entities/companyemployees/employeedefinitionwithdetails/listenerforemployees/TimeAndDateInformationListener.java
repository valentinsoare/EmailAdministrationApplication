package io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.listenerforemployees;

import io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.Employee;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.DAYS;

public class TimeAndDateInformationListener {

    public TimeAndDateInformationListener() {}

    @PrePersist
    public void generateTimeAndDateOnCreation(Object object) {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        if (object instanceof Employee employee) {
            employee.getTimeAndDateInformation().setCreationProfileDate(currentDate);
            employee.getTimeAndDateInformation().setCreationProfileTime(currentTime);

            employee.getTimeAndDateInformation().setLastModificationOnProfileDate(currentDate);
            employee.getTimeAndDateInformation().setLastModificationOnProfileTime(currentTime);
        }
    }

    @PreUpdate
    public void generateTimeAndDateOnUpdates(Object object) {
        if (object instanceof Employee employee) {
            employee.getTimeAndDateInformation().setLastModificationOnProfileDate(LocalDate.now());
            employee.getTimeAndDateInformation().setLastModificationOnProfileTime(LocalTime.now());
        }
    }

    @PostLoad
    public void calculateNumberOfDaysFromHiringAndFromLastModification(Object object) {
        if (object instanceof Employee employee) {
            LocalDate whenHired = employee.getTimeAndDateInformation().getHireDate();
            LocalDate lastModification = employee.getTimeAndDateInformation().getLastModificationOnProfileDate();

            long numberOfDaysFromHiring =
                    DAYS.between(LocalDate.now(), whenHired);
            long numberOfDaysFromLastModification =
                    DAYS.between(LocalDate.now(), lastModification);

            employee.getTimeAndDateInformation()
                    .setNumberOfDaysFromHiring(new BigDecimal(numberOfDaysFromHiring));

            employee.getTimeAndDateInformation()
                    .setNumberOfDaysFromLastModification(new BigDecimal(numberOfDaysFromLastModification));
        }
    }
}
