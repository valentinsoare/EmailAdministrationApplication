package io.emailadministration.entities.businesscomponents.companyemployees;

import io.emailadministration.entities.businesscomponents.companydepartments.Development;
import io.emailadministration.entities.businesscomponents.companyemployees.employeedefinitionwithdetails.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;

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

    @OneToOne(mappedBy = "teamLeaderOfDepartment")
    private Development departmentWhereIsHiredAsTeamLeader;

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
                lastProjectWithTheCompany, evaluationForTheLastProject);
    }
}
