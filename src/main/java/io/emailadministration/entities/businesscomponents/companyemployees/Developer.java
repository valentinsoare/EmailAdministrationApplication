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
@BatchSize(size = 8)
@Entity(name = "Developer")
@DiscriminatorValue("Developer")
public class Developer extends Employee {

    @LazyGroup("DEVELOPER_INFO_FIRST_WAVE")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "department_id")
    private Development department;

    @LazyGroup("DEVELOPER_INFO_SECOND_WAVE")
    @Column(name = "is_team_leader")
    @Basic(fetch = FetchType.LAZY)
    private boolean isTeamLeader;

    @LazyGroup("DEVELOPER_INFO_SECOND_WAVE")
    @OneToOne(mappedBy = "teamLeaderOfDepartment")
    private Development departmentWhereIsHiredAsTeamLeader;

    @LazyGroup("DEVELOPER_INFO_THIRD_WAVE")
    @Column(name = "last_project_with_the_company")
    @Basic(fetch = FetchType.LAZY)
    private String lastProjectWithTheCompany;

    @LazyGroup("DEVELOPER_INFO_THIRD_WAVE")
    @Column(name = "evaluation_for_the_last_project")
    @Basic(fetch = FetchType.LAZY)
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
