package io.emailadministration.entities.companyemployees.employeedefinitionwithdetails;

import io.emailadministration.entities.companyemployees.*;
import io.emailadministration.entities.digitalcomponents.UserBuilder;

import java.time.LocalDate;

public class EmployeeBuilder {
    private Employee employee;

    public EmployeeBuilder(Employee employee) {
        this.employee = employee;
    }

    public EmployeeBuilder() {
        this.employee = new Employee();
    }

    public EmployeeBuilder setupFirstName(String firstName) {
        this.employee.setFirstName(firstName);
        return this;
    }

    public EmployeeBuilder setupLastName(String lastName) {
        this.employee.setLastName(lastName);
        return this;
    }

    public EmployeeBuilder setupDateOfBirth(LocalDate dateOfBirth) {
        this.employee.setDateOfBirth(dateOfBirth);
        return this;
    }

    public EmployeeBuilder setupPhoneNumber(int phoneNumber) {
        this.employee.setPhoneNumber(phoneNumber);
        return this;
    }

    public AddressBuilder lives() {
        return new AddressBuilder(this.employee);
    }

    public EmployeeBuilder setupEmployeeId(String employeeId) {
        this.employee.setEmployeeId(employeeId);
        return this;
    }

    public EmployeeBuilder setupDepartmentType(DepartmentType departmentType) {
        this.employee.setDepartmentWhereIamWorking(departmentType);
        return this;
    }

    public WorkDetailsBuilder work() {
        return new WorkDetailsBuilder(this.employee);
    }

    public TimeAndDateInformationBuilder when() {
        return new TimeAndDateInformationBuilder(this.employee);
    }

    public UserBuilder setupUser() {
        return new UserBuilder(this.employee);
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public AccountantBuilder constructAccountant() {
        return new AccountantBuilder(employee);
    }

    public DeveloperBuilder constructDeveloper() {
        return new DeveloperBuilder(employee);
    }

    public SalesAgentBuilder constructSalesAgent() {
        return new SalesAgentBuilder(employee);
    }
}
