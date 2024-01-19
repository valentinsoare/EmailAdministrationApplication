package io.emailadministration.entities.companydepartments.listeners;

import io.emailadministration.entities.companydepartments.Sales;
import io.emailadministration.entities.companyemployees.SalesAgent;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;

import java.util.Set;

public class SalesDepartmentListener {

    public SalesDepartmentListener() {}

    @PostUpdate
    @PostPersist
    @PostRemove
    public void findOutNumberOfEmployees(Object object) {
        if (object instanceof Sales sales) {
            Set<SalesAgent> employees =
                    sales.getSetOfEmployeesInTheDepartment();

            sales.setNumberOfEmployeesPerDepartment(employees.size());
        }
    }
}
