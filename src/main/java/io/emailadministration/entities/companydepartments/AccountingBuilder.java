package io.emailadministration.entities.companydepartments;

import io.emailadministration.entities.companydepartments.departmentstructurewithdetails.Department;
import io.emailadministration.entities.companyemployees.DepartmentType;

public class AccountingBuilder {

    private Accounting accounting;

    public AccountingBuilder() {
        this.accounting = new Accounting();
    }

    public AccountingBuilder(Department department) {
        this.accounting = new Accounting(department);
    }

    public AccountingBuilder setupNumberOfEmployeesPerDepartment(int numberOfEmployees) {
        if (numberOfEmployees < 0) {
            numberOfEmployees = 0;
        }

        this.accounting.setNumberOfEmployeesPerDepartment(numberOfEmployees);
        return this;
    }

    public Accounting build() {
        return this.accounting;
    }

    public void setAccounting(Accounting accounting) {
        this.accounting = accounting;
    }

    public Accounting getAccounting() {
        return accounting;
    }
}
