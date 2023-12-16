package io.emailadministration.entities.businesscomponents.companydepartments;

import io.emailadministration.entities.businesscomponents.companydepartments.departmentstructurewithdetails.Department;
import io.emailadministration.entities.businesscomponents.companyemployees.Accountant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@BatchSize(size = 8)
@DiscriminatorValue("Accounting")
@Entity(name = "Accounting")
public class Accounting extends Department {

    @LazyGroup("ACCOUNTING_DEPARTMENT_INFO")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_leader_accountanting_id", unique = true)
    private Accountant teamLeaderOfDepartment;

    @LazyGroup("ACCOUNTING_DEPARTMENT_INFO")
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private Set<Accountant> listOfEmployeesInTheDepartment = new LinkedHashSet<>();

    @LazyGroup("ACCOUNTING_DEPARTMENT_INFO")
    @Column(name = "numbers_of_employees_per_department")
    @Basic(fetch = FetchType.LAZY)
    private int numberOfEmployeesPerDepartment;

    public Accounting() {
        super();
    }

    @Override
    public String toString() {
        return String.format("AccountingDepartment [%s, teamLeaderEmployeeID: %s, numberOfEmployeesPerDepart: %s",
                super.toString(), teamLeaderOfDepartment.getEmployeeId(), numberOfEmployeesPerDepartment);
    }
}
