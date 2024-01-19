package io.emailadministration.entities.companyemployees.employeedefinitionwithdetails;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeAndDateInformationBuilder extends EmployeeBuilder {

    public TimeAndDateInformationBuilder(Employee employee) {
        this.setEmployee(employee);
    }

    public TimeAndDateInformationBuilder setupHireDate(LocalDate date) {
        this.getEmployee().getTimeAndDateInformation().setHireDate(date);
        return this;
    }
}
