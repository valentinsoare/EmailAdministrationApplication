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
@BatchSize(size = 16)
@DiscriminatorValue("accountant")
@Entity(name = "accountant")
public class Accountant extends Employee {
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "department_id")
    private Accounting department;

    @Column(name = "is_team_leader")
    private boolean isTeamLeader;

    @OneToOne(mappedBy = "teamLeaderOfDepartment")
    private Accounting departmentWhereIsHiredAsTeamLeader;

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
