package io.emailadministration.entities.companydepartments;

import io.emailadministration.entities.companydepartments.departmentstructurewithdetails.Department;
import io.emailadministration.entities.companyemployees.Developer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@BatchSize(size = 16)
@Entity(name = "development")
@DiscriminatorValue("development")
public class Development extends Department {
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private Set<Developer> listOfEmployeesInTheDepartment = new LinkedHashSet<>();

    @Getter
    @Setter
    @Transient
    private int numberOfEmployeesPerDepartment;

    @Column(name = "number_of_projects_completed_this_year", columnDefinition = "int default -1")
    private int numberOfProjectsCompletedThisYear;

    @Column(name = "number_of_projects_completed_last_year", columnDefinition = "int default -1")
    private int numberOfProjectsCompletedLastYear;

    @Column(name = "number_of_projects_in_working", columnDefinition = "int default -1")
    private int numberOfProjectsInWorking;

    public Development() {
        super();

        this.numberOfEmployeesPerDepartment = -1;
    }

    public Development(Development development) {
        this.listOfEmployeesInTheDepartment = new HashSet<>(development.getListOfEmployeesInTheDepartment());
        this.numberOfProjectsCompletedLastYear = development.getNumberOfProjectsCompletedLastYear();
        this.numberOfProjectsCompletedThisYear = development.getNumberOfProjectsCompletedThisYear();
        this.numberOfEmployeesPerDepartment = development.getNumberOfEmployeesPerDepartment();
        this.numberOfProjectsInWorking = development.getNumberOfProjectsInWorking();

        this.setDepartmentBusinessID(development.getDepartmentBusinessID());
        this.setWhichDepartmentIsThis(development.getWhichDepartmentIsThis());
        this.setLastYearEvaluationOfTheDepartment(development.getLastYearEvaluationOfTheDepartment());
    }

    public Development getCopyInstance(Development development) {
        Development dev = new Development(development);

        dev.setId(development.getId());
        dev.setVersion(development.getVersion());

        return dev;
    }

    public Development updateElement(Development development) {
        return new Development(development);
    }

    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Development that)) return false;
        if (!super.equals(o)) return false;

        if ((numberOfEmployeesPerDepartment != that.numberOfEmployeesPerDepartment) ||
            (numberOfProjectsCompletedThisYear != that.numberOfProjectsCompletedThisYear) ||
            (numberOfProjectsCompletedLastYear != that.numberOfProjectsCompletedLastYear)) {
                return false;
        }

        return numberOfProjectsInWorking == that.numberOfProjectsInWorking;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();

        result = 31 * result + numberOfEmployeesPerDepartment;
        result = 31 * result + numberOfProjectsCompletedThisYear;
        result = 31 * result + numberOfProjectsCompletedLastYear;
        result = 31 * result + numberOfProjectsInWorking;

        return result;
    }

    @Override
    public String toString() {
        return String.format("Developer [%s, numberOfEmployeesInTheDepartment: %s, " +
                        "numberOfProjectsCompletedThisYear: %s, numberOfProjectsCompletedLastYear: %s, " +
                        "numberOfProjectsInWorking: %s",
                super.toString(), numberOfEmployeesPerDepartment, numberOfProjectsCompletedThisYear,
                numberOfProjectsCompletedLastYear, numberOfProjectsInWorking);
    }
}
