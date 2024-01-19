package io.emailadministration.entities.companyemployees.employeedefinitionwithdetails;

import io.emailadministration.devcomponents.Component;
import io.emailadministration.printing.CustomPrinting;
import io.emailadministration.customdatastructureandoperationsonthem.operationswithdatastructures.OperationsOnMap;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@Embeddable
public class WorkDetails implements Comparable<WorkDetails>, Component<WorkDetails> {
    @Enumerated(EnumType.STRING)
    @Column(name = "type_of_work_contract")
    private TypeOfWorkContract typeOfWorkContract;

    @Column(name = "seniority_level")
    private SeniorityLevel seniorityLevel;

    @Column(name = "current_salary", columnDefinition = "decimal(38,2) default -1")
    private BigDecimal currentSalary;

    public WorkDetails() {}

    public WorkDetails(WorkDetails details) {
        this.typeOfWorkContract = details.getTypeOfWorkContract();
        this.seniorityLevel = details.getSeniorityLevel();
        this.currentSalary = new BigDecimal(String.valueOf(details.getCurrentSalary()));
    }

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

    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    public WorkDetails getCopyInstance(WorkDetails object) {
        return new WorkDetails(object);
    }
}
