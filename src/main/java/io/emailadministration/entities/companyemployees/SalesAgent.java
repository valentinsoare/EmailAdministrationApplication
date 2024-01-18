package io.emailadministration.entities.companyemployees;

import io.emailadministration.entities.companydepartments.Sales;
import io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import java.math.BigDecimal;

@Getter
@Setter
@BatchSize(size = 16)
@Entity(name = "sales_agent")
@DiscriminatorValue("sales_agent")
public class SalesAgent extends Employee {
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "department_id")
    private Sales department;

    @Column(name = "is_team_leader")
    private boolean isTeamLeader;

    @Column(name = "sales_volume_this_year")
    private BigDecimal salesVolumeThisYear;

    @Column(name = "average_of_sales_volume_this_year")
    private BigDecimal averageOfSalesVolumeThisYear;

    @Column(name = "number_of_zones_covered")
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