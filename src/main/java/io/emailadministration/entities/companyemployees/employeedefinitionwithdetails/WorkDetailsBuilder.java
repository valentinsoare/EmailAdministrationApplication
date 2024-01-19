package io.emailadministration.entities.companyemployees.employeedefinitionwithdetails;

import java.math.BigDecimal;

public class WorkDetailsBuilder extends EmployeeBuilder {

    public WorkDetailsBuilder(Employee employee) {
        this.setEmployee(employee);
    }

    public WorkDetailsBuilder setupTypeOfWorkContract(TypeOfWorkContract contract) {
        this.getEmployee().getWorkDetails().setTypeOfWorkContract(contract);
        return this;
    }

    public WorkDetailsBuilder setupSeniorityLevel(SeniorityLevel level) {
        this.getEmployee().getWorkDetails().setSeniorityLevel(level);
        return this;
    }

    public WorkDetailsBuilder setupCurrentSalary(BigDecimal salary) {
        if (salary.compareTo(new BigDecimal("0")) < 0) {
            salary = new BigDecimal("0");
        }

        this.getEmployee().getWorkDetails().setCurrentSalary(salary);
        return this;
    }
}
