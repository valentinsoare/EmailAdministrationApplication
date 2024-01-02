package io.emailadministration.entities.businesscomponents.companyemployees.employeedefinitionwithdetails;

import io.emailadministration.entities.businesscomponents.companyemployees.DepartmentType;
import io.emailadministration.entities.businesscomponents.digitalcomponents.UserBuilder;

import java.time.LocalDate;

public class EmployeeBuilder {

    private Employee employee;

    public EmployeeBuilder(Employee employee) {
        this.employee = employee;
    }

    public EmployeeBuilder setupFirstName(String firstName) {
        employee.setFirstName(firstName);
        return this;
    }

    public EmployeeBuilder setupLastName(String lastName) {
        employee.setLastName(lastName);
        return this;
    }

    public EmployeeBuilder setupDateOfBirth(LocalDate dateOfBirth) {
        employee.setDateOfBirth(dateOfBirth);
        return this;
    }

    public EmployeeBuilder setupPhoneNumber(int phoneNumber) {
        employee.setPhoneNumber(phoneNumber);
        return this;
    }

    public AddressBuilder lives() {
        return new AddressBuilder(employee);
    }

    public EmployeeBuilder setupEmployeeId(String employeeId) {
        employee.setEmployeeId(employeeId);
        return this;
    }

    public EmployeeBuilder setupDepartmentType(DepartmentType departmentType) {
        employee.setDepartmentWhereIamWorking(departmentType);
        return this;
    }

    public WorkDetailsBuilder work() {
        return new WorkDetailsBuilder(employee);
    }

    public TimeAndDateInformationBuilder timeAndDate() {
        return new TimeAndDateInformationBuilder(employee);
    }

    public UserBuilder setupUser() {
        return new UserBuilder();
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
