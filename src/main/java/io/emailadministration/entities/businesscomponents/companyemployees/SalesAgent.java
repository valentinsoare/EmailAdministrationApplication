package io.emailadministration.entities.businesscomponents.companyemployees;

import io.emailadministration.entities.businesscomponents.companydepartments.Sales;
import io.emailadministration.entities.businesscomponents.companyemployees.employeedefinitionwithdetails.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;

import java.math.BigDecimal;

@Getter
@Setter
@BatchSize(size = 8)
@Entity(name = "Sales_agent")
@DiscriminatorValue("Sales_agent")
public class SalesAgent extends Employee {

    @LazyGroup("SALES_AGENT_INFO_FIRST_WAVE")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
    @JoinColumn(name = "department_id")
    private Sales department;

    @LazyGroup("SALES_AGENT_INFO_SECOND_WAVE")
    @Column(name = "is_team_leader")
    @Basic(fetch = FetchType.LAZY)
    private boolean isTeamLeader;

    @LazyGroup("SALES_AGENT_INFO_SECOND_WAVE")
    @OneToOne(mappedBy = "teamLeaderOfDepartment")
    private Sales departmentWhereIsHiredAsTeamLeader;

    @LazyGroup("SALES_AGENT_INFO_THIRD_WAVE")
    @Column(name = "sales_volume_this_year")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal salesVolumeThisYear;

    @LazyGroup("SALES_AGENT_INFO_THIRD_WAVE")
    @Column(name = "average_of_sales_volume_this_year")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal averageOfSalesVolumeThisYear;

    @LazyGroup("SALES_AGENT_INFO_THIRD_WAVE")
    @Column(name = "number_of_zones_covered")
    @Basic(fetch = FetchType.LAZY)
    private int numberOfZonesCovered;

    public SalesAgent() {
        super();
    }

    @Override
    public String toString() {
        return String.format("SalesAgent [%s, isTeamLeader: %s, salesVolumeThisYear: %s, " +
                        "averageOfSalesVolumeThisYear: %s, numberOfZonesCovered: %s",
                super.toString(), isTeamLeader, salesVolumeThisYear,
                averageOfSalesVolumeThisYear, numberOfZonesCovered);
    }
}
