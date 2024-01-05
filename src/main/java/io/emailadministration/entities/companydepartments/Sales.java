package io.emailadministration.entities.companydepartments;

import io.emailadministration.entities.companydepartments.departmentstructurewithdetails.Department;
import io.emailadministration.entities.companyemployees.SalesAgent;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@BatchSize(size = 16)
@Entity(name = "sales")
@DiscriminatorValue("sales")
public class Sales extends Department {

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private Set<SalesAgent> listOfEmployeesInTheDepartment = new LinkedHashSet<>();

    @Column(name = "numbers_of_employees_per_department", columnDefinition = "int default -1")
    private int numberOfEmployeesPerDepartment;

    @Column(name = "target_for_sales_this_year", columnDefinition = "decimal(38,2) default -1")
    private BigDecimal targetForSalesThisYear;

    @Column(name = "last_year_target_was_reached", columnDefinition = "boolean default false")
    private boolean lastYearTargetWasReached;

    @Column(name = "target_for_sales_last_year", columnDefinition = "decimal(38,2) default -1")
    private BigDecimal targetForSalesLastYear;

    public Sales() {
        super();
    }

    @Override
    public String toString() {
        return String.format("Sales [%s, numberOfEmployeesPerDepartment: %s, " +
                        "targetForSalesThisYear: %s, lastYearTargetWasReached: %s, targetForSalesLastYear: %s",
                super.toString(), numberOfEmployeesPerDepartment,
                targetForSalesThisYear, lastYearTargetWasReached, targetForSalesLastYear);
    }
}
