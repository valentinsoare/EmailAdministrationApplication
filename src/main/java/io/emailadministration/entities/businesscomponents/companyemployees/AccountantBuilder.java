package io.emailadministration.entities.businesscomponents.companyemployees;

import io.emailadministration.entities.businesscomponents.companydepartments.Accounting;
import io.emailadministration.entities.businesscomponents.companyemployees.employeedefinitionwithdetails.AddressBuilder;
import io.emailadministration.entities.businesscomponents.companyemployees.employeedefinitionwithdetails.TimeAndDateInformationBuilder;
import io.emailadministration.entities.businesscomponents.companyemployees.employeedefinitionwithdetails.WorkDetailsBuilder;
import io.emailadministration.entities.businesscomponents.digitalcomponents.User;

import java.time.LocalDate;

public class AccountantBuilder {

    private Accountant accountant;

    public AccountantBuilder() {
        this.accountant = new Accountant();
        this.accountant.setDepartmentWhereIamWorking(DepartmentType.ACCOUNTING);
    }

    public AccountantBuilder setupFirstName(String firstName) {
        accountant.setFirstName(firstName);
        return this;
    }

    public AccountantBuilder setupLastName(String lastName) {
        accountant.setLastName(lastName);
        return this;
    }

    public AccountantBuilder setupDateOfBirth(LocalDate dateOfBirth) {
        accountant.setDateOfBirth(dateOfBirth);
        return this;
    }

    public AccountantBuilder setupPhoneNumber(int phoneNumber) {
        accountant.setPhoneNumber(phoneNumber);
        return this;
    }

    public AccountantBuilder setupEmployeeId(String employeeId) {
        accountant.setEmployeeId(employeeId);
        return this;
    }

    public AddressBuilder address() {
        return new AddressBuilder(accountant);
    }

    public WorkDetailsBuilder work() {
        return new WorkDetailsBuilder(accountant);
    }

    public TimeAndDateInformationBuilder time() {
        return new TimeAndDateInformationBuilder(accountant);
    }

    public AccountantBuilder setupUser(User user) {
        accountant.setUser(user);
        return this;
    }

    public AccountantBuilder setupDepartment(Accounting accounting) {
        accountant.setDepartment(accounting);
        return this;
    }

    public AccountantBuilder setupIsTeamLeader(boolean isTeamLeader) {
        accountant.setTeamLeader(isTeamLeader);
        return this;
    }

    public Accountant build() {
        return accountant;
    }
}
