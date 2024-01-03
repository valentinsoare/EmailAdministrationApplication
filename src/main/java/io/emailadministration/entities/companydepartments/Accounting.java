package io.emailadministration.entities.companydepartments;

import io.emailadministration.entities.companydepartments.departmentstructurewithdetails.Department;
import io.emailadministration.entities.companyemployees.Accountant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@DiscriminatorValue("accounting")
@Entity(name = "accounting")
public class Accounting extends Department {

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private Set<Accountant> listOfEmployeesInTheDepartment = new LinkedHashSet<>();

    @Column(name = "numbers_of_employees_per_department")
    private int numberOfEmployeesPerDepartment;

    public Accounting() {
        super();
    }

    @Override
    public String toString() {
        return String.format("AccountingDepartment [%s, numberOfEmployeesPerDepart: %s",
                super.toString(), numberOfEmployeesPerDepartment);
    }
}
