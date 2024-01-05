package io.emailadministration.entities.companydepartments;

import io.emailadministration.entities.companyemployees.DepartmentType;

public class AccountingBuilder {

    private Accounting accounting;

    public AccountingBuilder() {
        this.accounting = new Accounting();
    }

    public AccountingBuilder setupDepartmentBusinessId(String businessIdOfTheDepartment) {
        this.accounting.setDepartmentBusinessID(businessIdOfTheDepartment);
        return this;
    }

    public AccountingBuilder setupDepartmentType(DepartmentType type) {
        this.accounting.setWhichDepartmentIsThis(type);
        return this;
    }

    public AccountingBuilder setupLastYearEvaluation(int lastYearEvaluation) {
        this.accounting.setLastYearEvaluationOfTheDepartment(lastYearEvaluation);
        return this;
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
