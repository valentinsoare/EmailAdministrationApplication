package io.emailadministration.entities.businesscomponents.companydepartments.departmentstructurewithdetails;

import io.emailadministration.Printing.CustomPrinting;
import io.emailadministration.customdatastructureandoperationsonthem.operationswithdatastructures.OperationsOnMap;
import io.emailadministration.entities.businesscomponents.companyemployees.DepartmentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.jetbrains.annotations.NotNull;

import java.util.Map;


@Getter
@Setter
@BatchSize(size = 8)
@Entity(name = "Department")
@Table(name = "Department", schema = "Department")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.STRING,
        name = "department_type"
)
@DiscriminatorValue("none")
public abstract class Department implements Comparable<Department> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "department_business_id")
    private String departmentBusinessID;

    @Enumerated(EnumType.STRING)
    @Column(name = "whichDepartmentIsThis")
    private DepartmentType whichDepartmentIsThis;

    @Column(name = "last_year_evaluation_of_the_department")
    private int lastYearEvaluationOfTheDepartment;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    protected Department() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;

        Department that = (Department) o;

        return (departmentBusinessID.equals(that.departmentBusinessID)) &&
                (whichDepartmentIsThis == that.whichDepartmentIsThis);
    }

    @Override
    public int hashCode() {
        int result = departmentBusinessID.hashCode();

        result = 31 * result + whichDepartmentIsThis.hashCode();
        result = 31 * result + lastYearEvaluationOfTheDepartment;

        return result;
    }

    @Override
    public int compareTo(@NotNull Department o) {
        int valueToReturnAfterComparison = o.departmentBusinessID.compareTo(this.departmentBusinessID);

        if (valueToReturnAfterComparison == 0) {
            return o.whichDepartmentIsThis.compareTo(this.whichDepartmentIsThis);
        }

        return valueToReturnAfterComparison;
    }

    @Override
    public String toString() {
        Map<String, ?> characteristics = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(characteristics, "Department [");
    }
}
