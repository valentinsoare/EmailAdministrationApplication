package io.emailadministration.entities.companydepartments;

import io.emailadministration.entities.companydepartments.departmentstructurewithdetails.DepartmentBuilder;
import io.emailadministration.entities.companyemployees.DepartmentType;

public class DevelopmentBuilder {

    private Development development;

    public DevelopmentBuilder() {
        this.development = new Development();
    }

    public DevelopmentBuilder setupDepartmentBusinessId(String departmentBusinessId) {
        development.setDepartmentBusinessID(departmentBusinessId);
        return this;
    }

    public DevelopmentBuilder setupDepartmentType(DepartmentType type) {
        development.setWhichDepartmentIsThis(type);
        return this;
    }

    public DevelopmentBuilder setupLastYearEvaluation(int lastYearEvaluation) {
        development.setLastYearEvaluationOfTheDepartment(lastYearEvaluation);
        return this;
    }

    public DevelopmentBuilder setupNumberOfEmployeesPerDepartment(int numberOfEmployees) {
        this.development.setNumberOfEmployeesPerDepartment(numberOfEmployees);
        return this;
    }

    public DevelopmentBuilder setupNumberOfProjectsCompletedThisYear(int numberOfProjects) {
        this.development.setNumberOfProjectsCompletedThisYear(numberOfProjects);
        return this;
    }

    public DevelopmentBuilder setupNumberOfProjectsCompletedLastYear(int numberOfProjects) {
        this.development.setNumberOfProjectsCompletedLastYear(numberOfProjects);
        return this;
    }

    public DevelopmentBuilder setupNumberOfProjectsInWorking(int numberOfProjects) {
        this.development.setNumberOfProjectsInWorking(numberOfProjects);
        return this;
    }

    public Development build() {
        return this.development;
    }

    public void setDevelopment(Development development) {
        this.development = development;
    }
}
