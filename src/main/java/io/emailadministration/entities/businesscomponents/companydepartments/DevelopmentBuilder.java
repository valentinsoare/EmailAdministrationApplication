package io.emailadministration.entities.businesscomponents.companydepartments;

import io.emailadministration.entities.businesscomponents.companydepartments.departmentstructurewithdetails.DepartmentBuilder;

public class DevelopmentBuilder {

    private Development development;

    public DevelopmentBuilder() {
        this.development = new Development();
    }

    public DepartmentBuilder setupDepartment() {
        return new DepartmentBuilder(development);
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
