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
@BatchSize(size = 8)
@DiscriminatorValue("Development")
@Entity(name = "Development")
public class Development extends Department {
    @LazyGroup("DEVELOPMENT_DEPARTMENT_INFO_FIRST_WAVE")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "team_leader_development_id", unique = true)
    private Developer teamLeaderOfDepartment;

    @LazyGroup("DEVELOPMENT_DEPARTMENT_INFO_SECOND_WAVE")
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private Set<Developer> listOfEmployeesInTheDepartment = new LinkedHashSet<>();

    @LazyGroup("DEVELOPMENT_DEPARTMENT_INFO_SECOND_WAVE")
    @Column(name = "numbers_of_employees_per_department")
    @Basic(fetch = FetchType.LAZY)
    private int numberOfEmployeesPerDepartment;

    @LazyGroup("DEVELOPMENT_DEPARTMENT_INFO_FIRST_WAVE")
    @Column(name = "number_of_projects_completed_this_year")
    @Basic(fetch = FetchType.LAZY)
    private int numberOfProjectsCompletedThisYear;

    @LazyGroup("DEVELOPMENT_DEPARTMENT_INFO_FIRST_WAVE")
    @Column(name = "number_of_projects_completed_last_year")
    @Basic(fetch = FetchType.LAZY)
    private int numberOfProjectsCompletedLastYear;

    @LazyGroup("DEVELOPMENT_DEPARTMENT_INFO_FIRST_WAVE")
    @Column(name = "number_of_projects_in_working")
    @Basic(fetch = FetchType.LAZY)
    private int numberOfProjectsInWorking;

    public Development() {}

    @Override
    public String toString() {
        return String.format("Developer [%s, teamLeaderEmployeeID: %s, numberOfEmployeesInTheDepartment: %s, " +
                        "numberOfProjectsCompletedThisYear: %s, numberOfProjectsCompletedLastYear: %s, " +
                        "numberOfProjectsInWorking: %s",
                super.toString(), teamLeaderOfDepartment.getEmployeeId(), numberOfEmployeesPerDepartment,
                numberOfProjectsCompletedThisYear, numberOfProjectsCompletedLastYear, numberOfProjectsInWorking);
    }
}
