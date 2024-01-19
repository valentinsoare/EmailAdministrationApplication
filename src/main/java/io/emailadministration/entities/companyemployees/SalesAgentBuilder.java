package io.emailadministration.entities.companyemployees;

import io.emailadministration.entities.companydepartments.Sales;
import io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.Employee;
import io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.EmployeeBuilder;

import java.math.BigDecimal;

public class SalesAgentBuilder extends EmployeeBuilder {
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
        this.salesAgent.setSalesVolumeThisYear(sales);
        return this;
    }

    public SalesAgentBuilder setupAverageSalesVolumeThisYear(BigDecimal avgThisYear) {
        this.salesAgent.setAverageOfSalesVolumeThisYear(avgThisYear);
        return this;
    }

    public SalesAgentBuilder setupNumberOfZonesCovered(int numberOfZones) {
        this.salesAgent.setNumberOfZonesCovered(numberOfZones);
        return this;
    }

    public SalesAgent build() {
        return salesAgent;
    }
}
