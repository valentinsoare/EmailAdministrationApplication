package io.emailadministration.entities.companyemployees;

import io.emailadministration.devcomponents.Component;
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
public class Developer extends Employee implements Component<Developer> {
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "department_id")
    private Development department;

    @Column(name = "is_team_leader", columnDefinition = "boolean default false")
    private boolean isTeamLeader;

    @Column(name = "last_project_with_the_company", columnDefinition = "varchar(125) default 'none'")
    private String lastProjectWithTheCompany;

    @Column(name = "evaluation_for_the_last_project")
    private double evaluationForTheLastProject;

    public Developer() {
        super();
    }

    public Developer(Employee employee) {
        super(employee);
    }

    public Developer(Developer developer) {
        super(developer.returnEmployee());

        this.department = new Development(developer.getDepartment());
        this.isTeamLeader = developer.isTeamLeader();
        this.lastProjectWithTheCompany = new String(developer.getLastProjectWithTheCompany());
        this.evaluationForTheLastProject = developer.getEvaluationForTheLastProject();
    }

    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    public Developer getCopyInstance(Developer object) {
        Developer developer = new Developer(object);

        developer.setId(object.getId());
        developer.setVersion(object.getVersion());

        return developer;
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
