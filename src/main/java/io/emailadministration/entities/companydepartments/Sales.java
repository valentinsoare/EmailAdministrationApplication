package io.emailadministration.entities.companydepartments;

import io.emailadministration.entities.companydepartments.departmentstructurewithdetails.Department;
import io.emailadministration.entities.companyemployees.SalesAgent;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import java.math.BigDecimal;
import java.util.HashSet;
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

        this.numberOfEmployeesPerDepartment = -1;
    }

    public Sales(Sales sales) {
        this.listOfEmployeesInTheDepartment = new HashSet<>(sales.getListOfEmployeesInTheDepartment());
        this.numberOfEmployeesPerDepartment = sales.getNumberOfEmployeesPerDepartment();
        this.lastYearTargetWasReached = sales.isLastYearTargetWasReached();
        this.targetForSalesThisYear = sales.getTargetForSalesThisYear();
        this.targetForSalesLastYear = sales.getTargetForSalesLastYear();

        this.setDepartmentBusinessID(sales.getDepartmentBusinessID());
        this.setWhichDepartmentIsThis(sales.getWhichDepartmentIsThis());
        this.setLastYearEvaluationOfTheDepartment(sales.getLastYearEvaluationOfTheDepartment());
    }

    public Sales updateElement(Sales sales) {
        return new Sales(sales);
    }

    public Sales getCopyInstance(Sales sales) {
        Sales s =  new Sales(sales);

        s.setId(sales.getId());
        s.setVersion(sales.getVersion());

        return s;
    }

    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((!(o instanceof Sales sales)) || (!super.equals(o)))  return false;

        if ((numberOfEmployeesPerDepartment != sales.numberOfEmployeesPerDepartment) ||
                (lastYearTargetWasReached != sales.lastYearTargetWasReached) ||
                (!targetForSalesThisYear.equals(sales.targetForSalesThisYear))) {
            return false;
        }

        return targetForSalesLastYear.equals(sales.targetForSalesLastYear);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + numberOfEmployeesPerDepartment;
        result = 31 * result + targetForSalesThisYear.hashCode();
        result = 31 * result + (lastYearTargetWasReached ? 1 : 0);
        result = 31 * result + targetForSalesLastYear.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return String.format("Sales [%s, numberOfEmployeesPerDepartment: %s, " +
                        "targetForSalesThisYear: %s, lastYearTargetWasReached: %s, targetForSalesLastYear: %s",
                super.toString(), numberOfEmployeesPerDepartment,
                targetForSalesThisYear, lastYearTargetWasReached, targetForSalesLastYear);
    }
}
