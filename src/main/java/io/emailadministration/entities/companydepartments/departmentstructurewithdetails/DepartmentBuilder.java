package io.emailadministration.entities.companydepartments.departmentstructurewithdetails;

import io.emailadministration.entities.companydepartments.AccountingBuilder;
import io.emailadministration.entities.companydepartments.DevelopmentBuilder;
import io.emailadministration.entities.companydepartments.SalesBuilder;
import io.emailadministration.entities.companyemployees.DepartmentType;

public class DepartmentBuilder {

    private Department department;

    public DepartmentBuilder(Department department) {
        this.department = department;
    }

    public DepartmentBuilder() {
        this.department = new Department();
    }

    public DepartmentBuilder setupDepartmentBusinessId(String departmentBusinessId) {
        department.setDepartmentBusinessID(departmentBusinessId);
        return this;
    }

    public DepartmentBuilder setupDepartmentType(DepartmentType departmentType) {
        department.setWhichDepartmentIsThis(departmentType);
        return this;
    }

    public DepartmentBuilder setupLastYearEvaluationOfTheDepartment(int lastYearEvaluation) {
        department.setLastYearEvaluationOfTheDepartment(lastYearEvaluation);
        return this;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public AccountingBuilder constructAccountingDepartment() {
        return new AccountingBuilder(department);
    }

    public DevelopmentBuilder constructDevelopmentDepartment() {
        return new DevelopmentBuilder(department);
    }

    public SalesBuilder constructSalesDepartment() {
        return new SalesBuilder(department);
    }
}
