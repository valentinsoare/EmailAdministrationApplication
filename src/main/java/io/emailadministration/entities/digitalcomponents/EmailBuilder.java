package io.emailadministration.entities.digitalcomponents;

import io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.Employee;
import io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.EmployeeBuilder;

import java.math.BigDecimal;

public class EmailBuilder extends EmployeeBuilder {

    public EmailBuilder(Employee employee) {
        this.setEmployee(employee);
    }

    public EmailBuilder setupPrimaryEmailAddress(String emailAddress) {
        this.getEmployee().getUser().getEmail().setPrimaryEmailAddress(emailAddress);
        return this;
    }

    public EmailBuilder setupSecondaryEmailAddress(String emailAddress) {
        this.getEmployee().getUser().getEmail().setSecondaryEmailAddress(emailAddress);
        return this;
    }

    public EmailBuilder setupMailboxCapacity(BigDecimal capacity) {
        this.getEmployee().getUser().getEmail().setMailBoxCapacity(capacity);
        return this;
    }
}
