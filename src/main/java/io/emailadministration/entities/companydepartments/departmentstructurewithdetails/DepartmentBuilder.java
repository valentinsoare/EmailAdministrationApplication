package io.emailadministration.entities.companydepartments.departmentstructurewithdetails;

import io.emailadministration.entities.companyemployees.DepartmentType;

public class DepartmentBuilder {

    private Department department;

    public DepartmentBuilder(Department department) {
        this.department = department;
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
}
