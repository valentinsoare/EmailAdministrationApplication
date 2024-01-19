package io.emailadministration.entities.companyemployees;

import io.emailadministration.entities.companydepartments.Accounting;
import io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.*;

public class AccountantBuilder {

    private Accountant accountant;

    public AccountantBuilder(Employee employee) {
        this.accountant = new Accountant(employee);
    }

    public AccountantBuilder setupDepartment(Accounting accounting) {
        this.accountant.setDepartment(accounting);
        return this;
    }

    public AccountantBuilder isTeamLeader(boolean isTL) {
        this.accountant.setTeamLeader(isTL);
        return this;
    }

    public Accountant build() {
        return accountant;
    }
}
