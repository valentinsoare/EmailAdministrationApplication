package io.emailadministration.entities.businesscomponents.companyemployees;

import io.emailadministration.entities.businesscomponents.companydepartments.Accounting;
import io.emailadministration.entities.businesscomponents.companyemployees.employeedefinitionwithdetails.Employee;
import io.emailadministration.entities.businesscomponents.digitalcomponents.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;

@Getter
@Setter
@BatchSize(size = 8)
@DiscriminatorValue("Accountant")
@Entity(name = "Accountant")
public class Accountant extends Employee {
    @LazyGroup("ACCOUNTANT_INFO")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "department_id")
    private Accounting department;

    @LazyGroup("ACCOUNTANT_TEAM_LEADER")
    @Column(name = "is_team_leader")
    @Basic(fetch = FetchType.LAZY)
    private boolean isTeamLeader;

    @LazyGroup("ACCOUNTANT_TEAM_LEADER")
    @OneToOne(mappedBy = "teamLeaderOfDepartment")
    private Accounting departmentWhereIsHiredAsTeamLeader;

    @LazyGroup("ACCOUNTANT_USER")
    @OneToOne(mappedBy = "employeeProfile")
    private User user;

    public Accountant() {
        super();
    }

    @Override
    public String toString() {
        return String.format("Accountant [%s, isTeamLeader: %s",
                super.toString(), isTeamLeader);
    }
}
