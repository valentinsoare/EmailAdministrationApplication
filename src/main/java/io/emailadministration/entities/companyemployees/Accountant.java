package io.emailadministration.entities.companyemployees;

import io.emailadministration.devcomponents.Component;
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
public class Accountant extends Employee implements Component<Accountant> {
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "department_id")
    private Accounting department;

    @Column(name = "is_team_leader", columnDefinition = "boolean default false")
    private boolean isTeamLeader;

    public Accountant() {
        super();
    }

    public Accountant(Employee employee) {
        super(employee);
    }

    public Accountant(Accountant accountant) {
        super(accountant.returnEmployee());

        this.department = new Accounting(accountant.getDepartment());
        this.isTeamLeader = accountant.isTeamLeader();
    }

    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Accountant getPresentObject() {
        return this;
    }

    public Accountant getCopyInstance(Accountant object) {
        Accountant accountant = new Accountant(object);

        accountant.setId(object.getId());
        accountant.setVersion(object.getVersion());

        return accountant;
    }

    @Override
    public String toString() {
        return String.format("Accountant [%s, department: %s, isTeamLeader: %s ]",
                super.toString(), department, isTeamLeader);
    }
}
