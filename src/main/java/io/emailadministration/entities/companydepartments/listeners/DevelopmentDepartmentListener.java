package io.emailadministration.entities.companydepartments.listeners;

import io.emailadministration.entities.companydepartments.Accounting;
import io.emailadministration.entities.companydepartments.Development;
import io.emailadministration.entities.companyemployees.Accountant;
import io.emailadministration.entities.companyemployees.Developer;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;

import java.util.Set;

public class DevelopmentDepartmentListener {
    public DevelopmentDepartmentListener() {}

    @PostUpdate
    @PostPersist
    @PostRemove
    public void findOutNumberOfEmployees(Object object) {
        if (object instanceof Development development) {
            Set<Developer> employees =
                    development.getSetOfEmployeesInTheDepartment();

            development.setNumberOfEmployeesPerDepartment(employees.size());
        }
    }
}
