package io.emailadministration.entities.businesscomponents.companyemployees.employeedefinitionwithdetails;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeAndDateInformationBuilder {

    private Employee employee;

    public TimeAndDateInformationBuilder(Employee employee) {
        this.employee = employee;
    }

    public TimeAndDateInformationBuilder setupHireDate(LocalDate date) {
        employee.getTimeAndDateInformation().setHireDate(date);
        return this;
    }

    public TimeAndDateInformationBuilder setupCreationProfileDate(LocalDate date) {
        employee.getTimeAndDateInformation().setCreationProfileDate(date);
        return this;
    }

    public TimeAndDateInformationBuilder setupLastModificationOnProfileDate(LocalDate date) {
        employee.getTimeAndDateInformation().setLastModificationOnProfileDate(date);
        return this;
    }

    public TimeAndDateInformationBuilder setupCreationProfileTime(LocalTime time) {
        employee.getTimeAndDateInformation().setCreationProfileTime(time);
        return this;
    }

    public TimeAndDateInformationBuilder setupLastModificationOnProfileTime(LocalTime time) {
        employee.getTimeAndDateInformation().setLastModificationOnProfileTime(time);
        return this;
    }
}
