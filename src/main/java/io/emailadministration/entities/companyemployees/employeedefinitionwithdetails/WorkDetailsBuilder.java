package io.emailadministration.entities.companyemployees.employeedefinitionwithdetails;

import java.math.BigDecimal;

public class WorkDetailsBuilder {

    private Employee employee;

    public WorkDetailsBuilder(Employee employee) {
        this.employee = employee;
    }

    public WorkDetailsBuilder setupTypeOfWorkContract(TypeOfWorkContract contract) {
        employee.getWorkDetails().setTypeOfWorkContract(contract);
        return this;
    }

    public WorkDetailsBuilder setupSeniorityLevel(SeniorityLevel level) {
        employee.getWorkDetails().setSeniorityLevel(level);
        return this;
    }

    public WorkDetailsBuilder setupCurrentSalary(BigDecimal salary) {
        employee.getWorkDetails().setCurrentSalary(salary);
        return this;
    }
}
