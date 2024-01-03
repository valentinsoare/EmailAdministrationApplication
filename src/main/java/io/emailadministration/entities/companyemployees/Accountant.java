package io.emailadministration.entities.companyemployees;

import io.emailadministration.entities.companydepartments.Accounting;
import io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

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

    public Accountant() {
        super();
    }

    @Override
    public String toString() {
        return String.format("Accountant [%s, isTeamLeader: %s",
                super.toString(), isTeamLeader);
    }
}
