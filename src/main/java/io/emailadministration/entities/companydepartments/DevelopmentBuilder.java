package io.emailadministration.entities.companydepartments;

import io.emailadministration.entities.companydepartments.departmentstructurewithdetails.Department;

public class DevelopmentBuilder {

    private Development development;

    public DevelopmentBuilder() {
        this.development = new Development();
    }

    public DevelopmentBuilder(Department department) {
        this.development = new Development(department);
    }

    private int checkLessThanZero(int inputValue) {
        return Math.max(inputValue, 0);

    }

    public DevelopmentBuilder setupNumberOfEmployeesPerDepartment(int numberOfEmployees) {
        this.development.setNumberOfEmployeesPerDepartment(checkLessThanZero(numberOfEmployees));
        return this;
    }

    public DevelopmentBuilder setupNumberOfProjectsCompletedThisYear(int numberOfProjects) {
        this.development.setNumberOfProjectsCompletedThisYear(checkLessThanZero(numberOfProjects));
        return this;
    }

    public DevelopmentBuilder setupNumberOfProjectsCompletedLastYear(int numberOfProjects) {
        this.development.setNumberOfProjectsCompletedLastYear(checkLessThanZero(numberOfProjects));
        return this;
    }

    public DevelopmentBuilder setupNumberOfProjectsInWorking(int numberOfProjects) {
        this.development.setNumberOfProjectsInWorking(checkLessThanZero(numberOfProjects));
        return this;
    }

    public Development build() {
        return this.development;
    }

    public void setDevelopment(Development development) {
        this.development = development;
    }

    public Development getDevelopment() {
        return development;
    }
}
