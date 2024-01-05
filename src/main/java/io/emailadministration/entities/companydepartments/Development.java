package io.emailadministration.entities.companydepartments;

import io.emailadministration.entities.companydepartments.departmentstructurewithdetails.Department;
import io.emailadministration.entities.companyemployees.Developer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

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

    @Column(name = "numbers_of_employees_per_department", columnDefinition = "int default -1")
    private int numberOfEmployeesPerDepartment;

    @Column(name = "number_of_projects_completed_this_year", columnDefinition = "int default -1")
    private int numberOfProjectsCompletedThisYear;

    @Column(name = "number_of_projects_completed_last_year", columnDefinition = "int default -1")
    private int numberOfProjectsCompletedLastYear;

    @Column(name = "number_of_projects_in_working", columnDefinition = "int default -1")
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
