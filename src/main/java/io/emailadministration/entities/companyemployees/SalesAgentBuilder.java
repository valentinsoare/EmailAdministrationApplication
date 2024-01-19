package io.emailadministration.entities.companyemployees;

import io.emailadministration.entities.companydepartments.Sales;
import io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.Employee;

import java.math.BigDecimal;

public class SalesAgentBuilder {
    private SalesAgent salesAgent;

    public SalesAgentBuilder(Employee employee) {
        this.salesAgent = new SalesAgent(employee);
    }

    public SalesAgentBuilder setupDepartment(Sales sales) {
        this.salesAgent.setDepartment(sales);
        return this;
    }

    public SalesAgentBuilder setupIsTeamLeader(boolean isTeamLeader) {
        this.salesAgent.setTeamLeader(isTeamLeader);
        return this;
    }

    public SalesAgentBuilder setupSalesVolumeThisYear(BigDecimal sales) {
        this.salesAgent.setSalesVolumeThisYear(sales.max(new BigDecimal("0")));
        return this;
    }

    public SalesAgentBuilder setupAverageSalesVolumeThisYear(BigDecimal avgThisYear) {
        this.salesAgent.setAverageOfSalesVolumeThisYear(avgThisYear.max(new BigDecimal("0")));
        return this;
    }

    public SalesAgentBuilder setupNumberOfZonesCovered(int numberOfZones) {
        this.salesAgent.setNumberOfZonesCovered(Math.max(numberOfZones, 0));
        return this;
    }

    public SalesAgent build() {
        return salesAgent;
    }
}
