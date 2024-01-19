package io.emailadministration.entities.digitalcomponents;

import io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.Employee;
import io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.EmployeeBuilder;

public class UserBuilder extends EmployeeBuilder {

    public UserBuilder(Employee employee) {
        this.setEmployee(employee);
    }

    public UserBuilder setupUserName(String userName) {
        this.getEmployee().getUser().setUserName(userName);
        return this;
    }

    public PasswordBuilder asPassword () {
        return new PasswordBuilder(this.getEmployee());
    }

    public EmailBuilder asEmail() {
        return new EmailBuilder(this.getEmployee());
    }
}
