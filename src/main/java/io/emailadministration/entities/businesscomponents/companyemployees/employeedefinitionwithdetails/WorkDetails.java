package io.emailadministration.entities.businesscomponents.companyemployees.employeedefinitionwithdetails;

import io.emailadministration.Printing.CustomPrinting;
import io.emailadministration.customdatastructureandoperationsonthem.operationswithdatastructures.OperationsOnMap;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@Embeddable
public class WorkDetails implements Comparable<WorkDetails> {
    @LazyGroup("WORK_DETAILS")
    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_work_contract")
    @Basic(fetch = FetchType.LAZY)
    private TypeOfWorkContract typeOfWorkContract;

    @LazyGroup("WORK_DETAILS")
    @Column(name = "seniority_level")
    @Basic(fetch = FetchType.LAZY)
    private SeniorityLevel seniorityLevel;

    @LazyGroup("WORK_DETAILS")
    @Column(name = "current_salary")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal currentSalary;

    public WorkDetails() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkDetails that)) return false;

        if ( (that.typeOfWorkContract != typeOfWorkContract) ||
                (!that.currentSalary.equals(currentSalary))) {
            return false;
        }

        return that.seniorityLevel == seniorityLevel;
    }

    @Override
    public int hashCode() {
        int result = typeOfWorkContract.hashCode();

        result = 31 * result + seniorityLevel.hashCode();
        result = 31 * result + currentSalary.hashCode();

        return result;
    }


    @Override
    public int compareTo(@NotNull WorkDetails o) {
        int valueAfterComparison = o.seniorityLevel.compareTo(this.seniorityLevel);

        if (valueAfterComparison == 0) {
            return o.currentSalary.compareTo(this.currentSalary);
        }

        return valueAfterComparison;
    }

    @Override
    public String toString() {
        Map<String, ?> characteristics = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(characteristics, "WorkDetails [");
    }
}