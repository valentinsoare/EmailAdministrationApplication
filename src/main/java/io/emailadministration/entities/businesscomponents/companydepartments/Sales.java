package io.emailadministration.entities.businesscomponents.companydepartments;

import io.emailadministration.entities.businesscomponents.companydepartments.departmentstructurewithdetails.Department;
import io.emailadministration.entities.businesscomponents.companyemployees.SalesAgent;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@DiscriminatorValue("sales")
@Entity(name = "sales")
public class Sales extends Department {
    @OneToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "team_leader_sales_id", unique = true, nullable = false)
    private SalesAgent teamLeaderOfDepartment;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private Set<SalesAgent> listOfEmployeesInTheDepartment = new LinkedHashSet<>();

    @Column(name = "numbers_of_employees_per_department", nullable = false)
    private int numberOfEmployeesPerDepartment;

    @Column(name = "target_for_sales_this_year", nullable = false)
    private BigDecimal targetForSalesThisYear;

    @Column(name = "last_year_target_was_reached", nullable = false)
    private boolean lastYearTargetWasReached;

    @Column(name = "target_for_sales_last_year", nullable = false)
    private BigDecimal targetForSalesLastYear;

    public Sales() {
        super();
    }

    @Override
    public String toString() {
        return String.format("Sales [%s, teamLeaderIDOfTheDepartment: %s, numberOfEmployeesPerDepartment: %s, " +
                        "targetForSalesThisYear: %s, lastYearTargetWasReached: %s, targetForSalesLastYear: %s",
                super.toString(), teamLeaderOfDepartment.getEmployeeId(), numberOfEmployeesPerDepartment,
                targetForSalesThisYear, lastYearTargetWasReached, targetForSalesLastYear);
    }
}
