package io.emailadministration.entities.businesscomponents.companydepartments;

import io.emailadministration.entities.businesscomponents.companydepartments.departmentstructurewithdetails.DepartmentBuilder;
import io.emailadministration.entities.businesscomponents.companyemployees.SalesAgent;

import java.math.BigDecimal;

public class SalesBuilder {
    private Sales sales;

    public SalesBuilder() {
        this.sales = new Sales();
    }

    public DepartmentBuilder setupDepartment() {
        return new DepartmentBuilder(sales);
    }

    public SalesBuilder setupNumberOfEmployeesPerDepartment(int numberOfEmployees) {
        sales.setNumberOfEmployeesPerDepartment(numberOfEmployees);
        return this;
    }

    public SalesBuilder setupTargetForSalesThisYear(BigDecimal target) {
        sales.setTargetForSalesThisYear(target);
        return this;
    }

    public SalesBuilder setupTargetForSalesLastYear(BigDecimal target) {
        sales.setTargetForSalesLastYear(target);
        return this;
    }

    public SalesBuilder setupLastYearTargetWasReached(boolean lastYearTargetReached) {
        sales.setLastYearTargetWasReached(lastYearTargetReached);
        return this;
    }

    public Sales build() {
        return sales;
    }
}
