package io.emailadministration.entities.companydepartments;

import io.emailadministration.dbutils.DBConnection;
import io.emailadministration.entities.companydepartments.departmentstructurewithdetails.Department;
import io.emailadministration.entities.companydepartments.listeners.AccountingDepartmentListener;
import io.emailadministration.entities.companyemployees.Accountant;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@DiscriminatorValue("accounting")
@Entity(name = "accounting")
@EntityListeners( {AccountingDepartmentListener.class} )
public class Accounting extends Department {

    @OneToMany(mappedBy = "department")
    private Set<Accountant> setEmployeesInTheDepartment = new LinkedHashSet<>();

    @Getter
    @Setter
    @Transient
    private int numberOfEmployeesPerDepartment;

    public Accounting() {
        super();

        this.numberOfEmployeesPerDepartment = -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Accounting that)) return false;
        if (!super.equals(o)) return false;

        return numberOfEmployeesPerDepartment == that.numberOfEmployeesPerDepartment;
    }

    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    public Accounting(Accounting accounting) {
        this.setEmployeesInTheDepartment = new HashSet<>(accounting.setEmployeesInTheDepartment);
        this.numberOfEmployeesPerDepartment = accounting.getNumberOfEmployeesPerDepartment();

        this.setWhichDepartmentIsThis(accounting.getWhichDepartmentIsThis());
        this.setDepartmentBusinessID(accounting.getDepartmentBusinessID());
        this.setLastYearEvaluationOfTheDepartment(accounting.getLastYearEvaluationOfTheDepartment());
        this.setId(accounting.getId());
        this.setVersion(accounting.getVersion());
    }

    public Accounting getCopyInstance(Accounting accounting) {
        return new Accounting(accounting);
    }

    public void updateElement(Accounting accounting) {
        this.setEmployeesInTheDepartment = new HashSet<>(accounting.setEmployeesInTheDepartment);
        this.numberOfEmployeesPerDepartment = accounting.getNumberOfEmployeesPerDepartment();
        this.setDepartmentBusinessID(accounting.getDepartmentBusinessID());
        this.setWhichDepartmentIsThis(accounting.getWhichDepartmentIsThis());
        this.setLastYearEvaluationOfTheDepartment(accounting.getLastYearEvaluationOfTheDepartment());
    }

    public Set<Accountant> getSetOfEmployeesInTheDepartment() {
        EntityManager em = DBConnection.getInstance().generateEntityManager();



        TypedQuery<Accountant> query = em.createQuery("SELECT a.setEmployeesInTheDepartment FROM accounting a",
                Accountant.class);

        try (em) {
            this.setEmployeesInTheDepartment = new HashSet<>(query.getResultList());
            return setEmployeesInTheDepartment;
        } catch (Exception e) {
            System.out.printf("ERROR - [Accounting.getSetOfEmployees] - %s", e.getMessage());
        }

        return Collections.emptySet();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + numberOfEmployeesPerDepartment;
        return result;
    }

    @Override
    public String toString() {
        getSetOfEmployeesInTheDepartment();

        return String.format("AccountingDepartment [ %s, numberOfEmployeesPerDepartment: %s, employees: %s ]",
                super.toString(), numberOfEmployeesPerDepartment, setEmployeesInTheDepartment);
    }
}
