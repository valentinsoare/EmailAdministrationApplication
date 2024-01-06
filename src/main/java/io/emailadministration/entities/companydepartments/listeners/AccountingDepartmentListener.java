package io.emailadministration.entities.companydepartments.listeners;

import io.emailadministration.entities.companydepartments.Accounting;
import io.emailadministration.entities.companyemployees.Accountant;
import jakarta.persistence.*;

import java.util.Set;

public class AccountingDepartmentListener {

    public AccountingDepartmentListener() {}

    @PostUpdate
    @PostPersist
    @PostRemove
    public void findOutNumberOfEmployees(Object object) {
        if (object instanceof Accounting accounting) {
            Set<Accountant> employees =
                    accounting.getSetOfEmployeesInTheDepartment();

            accounting.setNumberOfEmployeesPerDepartment(employees.size());
        }
    }
}
