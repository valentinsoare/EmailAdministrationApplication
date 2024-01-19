package io.emailadministration.entities.companyemployees;

import io.emailadministration.entities.companydepartments.Development;
import io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.Employee;
import io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.EmployeeBuilder;

public class DeveloperBuilder {

    private Developer developer;

    public DeveloperBuilder(Employee employee) {
        this.developer = new Developer(employee);
    }

    public DeveloperBuilder setupDepartment(Development development) {
        this.developer.setDepartment(development);
        return this;
    }

    public DeveloperBuilder setupIsTeamLeader(boolean isTeamLeader) {
        this.developer.setTeamLeader(isTeamLeader);
        return this;
    }

    public DeveloperBuilder setupLastProjectWithTheCompany(String lastProject) {
        this.developer.setLastProjectWithTheCompany(lastProject);
        return this;
    }

    public DeveloperBuilder setupEvaluationForTheLastProject(double evaluationForTheLastProject) {
        this.developer.setEvaluationForTheLastProject(evaluationForTheLastProject);
        return this;
    }

    public Developer build() {
        return developer;
    }
}
