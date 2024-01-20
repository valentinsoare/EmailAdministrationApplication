package io.emailadministration.entities.digitalcomponents;

import io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.Employee;
import io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.EmployeeBuilder;
import org.apache.commons.lang3.tuple.Pair;

public class PasswordBuilder extends EmployeeBuilder {

    public PasswordBuilder(Employee employee) {
        this.setEmployee(employee);
    }

    public PasswordBuilder setupPasswordLengthForUser(Pair<Integer, Integer> lengthInterval) {
        this.getEmployee().getUser().getPassword().setMandatoryPasswordLengthForUser(lengthInterval);
        return this;
    }

    public PasswordBuilder setupPasswordLengthForEmail(Pair<Integer, Integer> lengthInterval) {
        this.getEmployee().getUser().getPassword().setMandatoryPasswordLengthForEmail(lengthInterval);
        return this;
    }

    public PasswordBuilder setupPasswordForUser(String passwordForUser) {
        this.getEmployee().getUser().getPassword().hashedPasswordForUser(passwordForUser);
        return this;
    }

    public PasswordBuilder setupPasswordForEmail(String passwordForEmail) {
        this.getEmployee().getUser().getPassword().hashedPasswordForEmail(passwordForEmail);
        return this;
    }
}
