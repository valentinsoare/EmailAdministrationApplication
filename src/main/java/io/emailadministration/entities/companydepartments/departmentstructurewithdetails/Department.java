package io.emailadministration.entities.companydepartments.departmentstructurewithdetails;

import io.emailadministration.entities.companyemployees.DepartmentType;
import io.emailadministration.printing.CustomPrinting;
import io.emailadministration.customdatastructureandoperationsonthem.operationswithdatastructures.OperationsOnMap;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Map;


@Getter
@Setter
@Entity(name = "department")
@Table(name = "department", schema = "department")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.STRING,
        name = "department_type"
)
@DiscriminatorValue("none")
public class Department implements Comparable<Department> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "department_business_id", columnDefinition = "varchar(100) default 'none'", unique = true)
    private String departmentBusinessID;

    @Enumerated(EnumType.STRING)
    @Column(name = "whichDepartmentIsThis", unique = true)
    private DepartmentType whichDepartmentIsThis;

    @Column(name = "last_year_evaluation_of_the_department", columnDefinition = "int default -1")
    private int lastYearEvaluationOfTheDepartment;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    protected Department() {
        this.lastYearEvaluationOfTheDepartment = -1;
        this.version = -1L;
        this.id = -1L;
        this.departmentBusinessID = "none";
        this.whichDepartmentIsThis = DepartmentType.ACCOUNTING;
    }

    protected Department(Department department) {
        this.id = department.getId();
        this.departmentBusinessID = department.getDepartmentBusinessID();
        this.whichDepartmentIsThis = department.getWhichDepartmentIsThis();
        this.lastYearEvaluationOfTheDepartment = department.getLastYearEvaluationOfTheDepartment();
        this.version = department.getVersion();
    }

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
        Department d = new Department(this);

        Map<String, ?> characteristics = OperationsOnMap.putObjectAttributes(d);
        return CustomPrinting.of(characteristics, "");
    }
}
