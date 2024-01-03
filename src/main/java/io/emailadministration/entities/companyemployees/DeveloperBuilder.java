package io.emailadministration.entities.companyemployees;

import io.emailadministration.entities.companydepartments.Development;
import io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.EmployeeBuilder;

public class DeveloperBuilder {
    private Developer developer;

    public DeveloperBuilder() {
        this.developer = new Developer();
        this.developer.setDepartmentWhereIamWorking(DepartmentType.DEVELOPMENT);
    }

    public EmployeeBuilder employeeBuilder() {
        return new EmployeeBuilder(developer);
    }

    public DeveloperBuilder setupDepartment(Development development) {
        developer.setDepartment(development);
        return this;
    }

    public DeveloperBuilder setupIsTeamLeader(boolean isTeamLeader) {
        developer.setTeamLeader(isTeamLeader);
        return this;
    }

    public DeveloperBuilder setupLastProjectWithTheCompany(String lastProject) {
        developer.setLastProjectWithTheCompany(lastProject);
        return this;
    }

    public DeveloperBuilder setupEvaluationForTheLastProject(double evaluationForTheLastProject) {
        developer.setEvaluationForTheLastProject(evaluationForTheLastProject);
        return this;
    }

    public Developer build() {
        return developer;
    }
}
