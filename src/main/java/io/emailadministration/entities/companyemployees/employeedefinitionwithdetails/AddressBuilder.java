package io.emailadministration.entities.companyemployees.employeedefinitionwithdetails;

public class AddressBuilder extends EmployeeBuilder {

    public AddressBuilder(Employee employee) {
        this.setEmployee(employee);
    }

    public AddressBuilder setupStreet(String street) {
        this.getEmployee().getAddress().setStreet(street);
        return this;
    }

    public AddressBuilder setupNumber(int number) {
        this.getEmployee().getAddress().setNumber(number);
        return this;
    }

    public AddressBuilder setupApartment(int apartment) {
        this.getEmployee().getAddress().setApartment(apartment);
        return this;
    }

    public AddressBuilder setupCity(String city) {
        this.getEmployee().getAddress().setCity(city);
        return this;
    }

    public AddressBuilder setupCountry(String country) {
        this.getEmployee().getAddress().setCountry(country);
        return this;
    }

    public AddressBuilder setupZipCode(int zipCode) {
        this.getEmployee().getAddress().setZipcode(zipCode);
        return this;
    }
}
