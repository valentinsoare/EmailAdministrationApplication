package io.emailadministration.entities.companyemployees.employeedefinitionwithdetails;

public class AddressBuilder {

    private Employee employee;

    public AddressBuilder(Employee employee) {
        this.employee = employee;
    }

    public AddressBuilder setupStreet(String street) {
        employee.getAddress().setStreet(street);
        return this;
    }

    public AddressBuilder setupNumber(int number) {
        employee.getAddress().setNumber(number);
        return this;
    }

    public AddressBuilder setupApartment(int apartment) {
        employee.getAddress().setApartment(apartment);
        return this;
    }

    public AddressBuilder setupCity(String city) {
        employee.getAddress().setCity(city);
        return this;
    }

    public AddressBuilder setupCountry(String country) {
        employee.getAddress().setCountry(country);
        return this;
    }

    public AddressBuilder setupZipCode(int zipCode) {
        employee.getAddress().setZipcode(zipCode);
        return this;
    }
}
