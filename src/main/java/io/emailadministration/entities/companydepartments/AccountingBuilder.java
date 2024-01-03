package io.emailadministration.entities.companydepartments;

import io.emailadministration.entities.companydepartments.departmentstructurewithdetails.DepartmentBuilder;

public class AccountingBuilder {

    private Accounting accounting;

    public AccountingBuilder() {
        this.accounting = new Accounting();
    }

    public DepartmentBuilder setupDepartment() {
        return new DepartmentBuilder(accounting);
    }

    public AccountingBuilder setupNumberOfEmployeesPerDepartment(int numberOfEmployees) {
        this.accounting.setNumberOfEmployeesPerDepartment(numberOfEmployees);
        return this;
    }

    public Accounting build() {
        return this.accounting;
    }

    public void setAccounting(Accounting accounting) {
        this.accounting = accounting;
    }
}
