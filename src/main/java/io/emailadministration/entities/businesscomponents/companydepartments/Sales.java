package io.emailadministration.entities.businesscomponents.companydepartments;

import io.emailadministration.entities.businesscomponents.companydepartments.departmentstructurewithdetails.Department;
import io.emailadministration.entities.businesscomponents.companyemployees.SalesAgent;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@BatchSize(size = 8)
@DiscriminatorValue("Sales")
@Entity(name = "Sales")
public class Sales extends Department {
    @LazyGroup("SALES_DEPARTMENT_INFO_FIRST_WAVE")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_leader_sales_id", unique = true)
    private SalesAgent teamLeaderOfDepartment;

    @LazyGroup("SALES_DEPARTMENT_INFO_SECOND_WAVE")
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private Set<SalesAgent> listOfEmployeesInTheDepartment = new LinkedHashSet<>();

    @LazyGroup("SALES_DEPARTMENT_INFO_SECOND_WAVE")
    @Column(name = "numbers_of_employees_per_department")
    @Basic(fetch = FetchType.LAZY)
    private int numberOfEmployeesPerDepartment;

    @LazyGroup("SALES_DEPARTMENT_INFO_FIRST_WAVE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "target_for_sales_this_year")
    private BigDecimal targetForSalesThisYear;

    @LazyGroup("SALES_DEPARTMENT_INFO_THIRD_WAVE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "last_year_target_was_reached")
    private boolean lastYearTargetWasReached;

    @LazyGroup("SALES_DEPARTMENT_INFO_THIRD_WAVE")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "target_for_sales_last_year")
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
