package io.emailadministration.entities.companydepartments;

import io.emailadministration.entities.companydepartments.departmentstructurewithdetails.Department;
import io.emailadministration.entities.companyemployees.DepartmentType;

import java.math.BigDecimal;

public class SalesBuilder {
    private Sales sales;

    public SalesBuilder() {
        this.sales = new Sales();
    }

    public SalesBuilder(Department department) {
        this.sales = new Sales(department);
    }

    public SalesBuilder setupNumberOfEmployeesPerDepartment(int numberOfEmployees) {
        sales.setNumberOfEmployeesPerDepartment(Math.max(numberOfEmployees, 0));
        return this;
    }

    public SalesBuilder setupTargetForSalesThisYear(BigDecimal target) {
        sales.setTargetForSalesThisYear(target.max(new BigDecimal("0")));
        return this;
    }

    public SalesBuilder setupTargetForSalesLastYear(BigDecimal target) {
        sales.setTargetForSalesLastYear(target.max(new BigDecimal("0")));
        return this;
    }

    public SalesBuilder setupLastYearTargetWasReached(boolean lastYearTargetReached) {
        sales.setLastYearTargetWasReached(lastYearTargetReached);
        return this;
    }

    public Sales build() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
    }

    public Sales getSales() {
        return sales;
    }
}
