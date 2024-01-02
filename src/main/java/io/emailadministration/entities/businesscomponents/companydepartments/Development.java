package io.emailadministration.entities.businesscomponents.companydepartments;

import io.emailadministration.entities.businesscomponents.companydepartments.departmentstructurewithdetails.Department;
import io.emailadministration.entities.businesscomponents.companyemployees.Developer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;

import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
@Entity(name = "development")
@DiscriminatorValue("development")
public class Development extends Department {
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private Set<Developer> listOfEmployeesInTheDepartment = new LinkedHashSet<>();

    @Column(name = "numbers_of_employees_per_department")
    private int numberOfEmployeesPerDepartment;

    @Column(name = "number_of_projects_completed_this_year")
    private int numberOfProjectsCompletedThisYear;

    @Column(name = "number_of_projects_completed_last_year")
    private int numberOfProjectsCompletedLastYear;

    @Column(name = "number_of_projects_in_working")
    private int numberOfProjectsInWorking;

    public Development() {
        super();
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
