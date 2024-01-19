package io.emailadministration.entities.companydepartments;

import io.emailadministration.dbutils.DBConnection;
import io.emailadministration.devcomponents.Component;
import io.emailadministration.entities.companydepartments.departmentstructurewithdetails.Department;
import io.emailadministration.entities.companydepartments.listeners.SalesDepartmentListener;
import io.emailadministration.entities.companyemployees.SalesAgent;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@BatchSize(size = 16)
@Entity(name = "sales")
@DiscriminatorValue("sales")
@EntityListeners( {SalesDepartmentListener.class} )
public class Sales extends Department implements Component<Sales> {

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private Set<SalesAgent> setEmployeesInTheDepartment = new LinkedHashSet<>();

    @Getter
    @Setter
    @Transient
    private int numberOfEmployeesPerDepartment;

    @Column(name = "target_for_sales_this_year", columnDefinition = "decimal(38,2) default -1")
    private BigDecimal targetForSalesThisYear;

    @Column(name = "last_year_target_was_reached", columnDefinition = "boolean default false")
    private boolean lastYearTargetWasReached;

    @Column(name = "target_for_sales_last_year", columnDefinition = "decimal(38,2) default -1")
    private BigDecimal targetForSalesLastYear;

    public Sales() {
        super();

        this.targetForSalesThisYear = new BigDecimal("0");
        this.targetForSalesLastYear = new BigDecimal("0");
    }

    public Sales(Sales sales) {
        this.setEmployeesInTheDepartment = new HashSet<>(sales.setEmployeesInTheDepartment);
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

    public Set<SalesAgent> getSetOfEmployeesInTheDepartment() {
        EntityManager em = DBConnection.getInstance().generateEntityManager();

        TypedQuery<SalesAgent> query = em.createQuery("SELECT s.setEmployeesInTheDepartment FROM sales s",SalesAgent.class);

        try (em) {
            this.setEmployeesInTheDepartment = new HashSet<>(query.getResultList());
            this.numberOfEmployeesPerDepartment = setEmployeesInTheDepartment.size();

            return setEmployeesInTheDepartment;
        } catch (Exception e) {
            System.out.printf("ERROR - [Sales.getSetOfEmployees] - %s", e.getMessage());
        }

        return Collections.emptySet();
    }

    @Override
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
