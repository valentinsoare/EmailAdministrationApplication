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
    @JoinColumn(name = "department_id", columnDefinition = "varchar(31) default 'none'")
    private Accounting department;

    @Column(name = "is_team_leader", columnDefinition = "boolean default false")
    private boolean isTeamLeader;

    public Accountant() {
        super();
    }

    public Accountant(Employee employee) {
        super(employee);
    }

    @Override
    public String toString() {
        return String.format("Accountant [%s, isTeamLeader: %s",
                super.toString(), isTeamLeader);
    }
}
