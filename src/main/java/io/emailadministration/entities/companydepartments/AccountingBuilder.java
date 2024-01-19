package io.emailadministration.entities.companydepartments;

import io.emailadministration.entities.companydepartments.departmentstructurewithdetails.Department;

public class AccountingBuilder {

    private Accounting accounting;

    public AccountingBuilder() {
        this.accounting = new Accounting();
    }

    public AccountingBuilder(Department department) {
        this.accounting = new Accounting(department);
    }

    public AccountingBuilder setupNumberOfEmployeesPerDepartment(int numberOfEmployees) {
        this.accounting.setNumberOfEmployeesPerDepartment(Math.max(numberOfEmployees, 0));
        return this;
    }

    public Accounting build() {
        return this.accounting;
    }
}
