package io.emailadministration.entities.companyemployees;

import io.emailadministration.entities.companydepartments.Development;
import io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

@Getter
@Setter
@BatchSize(size = 16)
@Entity(name = "developer")
@DiscriminatorValue("developer")
public class Developer extends Employee {
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "department_id")
    private Development department;

    @Column(name = "is_team_leader")
    private boolean isTeamLeader;

    @Column(name = "last_project_with_the_company")
    private String lastProjectWithTheCompany;

    @Column(name = "evaluation_for_the_last_project")
    private double evaluationForTheLastProject;

    public Developer() {
        super();
    }

    @Override
    public String toString() {
        return String.format("Developer [%s, isTeamLeader: %s, " +
                        "lastProjectWithCompany: %s, evaluationForTheLastProject: %s",
                super.toString(), isTeamLeader,
                lastProjectWithTheCompany,
                evaluationForTheLastProject);
    }
}
