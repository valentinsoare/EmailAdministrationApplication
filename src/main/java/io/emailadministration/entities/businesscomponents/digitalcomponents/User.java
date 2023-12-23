package io.emailadministration.entities.businesscomponents.digitalcomponents;

import io.emailadministration.Printing.CustomPrinting;
import io.emailadministration.customdatastructureandoperationsonthem.operationswithdatastructures.OperationsOnMap;
import io.emailadministration.entities.businesscomponents.companyemployees.employeedefinitionwithdetails.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Getter
@Setter
@BatchSize(size = 8)
@Entity(name = "User")
@Table(name = "User", schema = "User")
public class User implements Comparable<User> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_profile", unique = true)
    private Employee employeeProfile;

    @Column(name = "user_name")
    private String userName;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_password", unique = true)
    private Password password;

    @OneToOne(mappedBy = "user")
    private Email email;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    public User() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (!userName.equals(user.userName)) return false;
        return user.password.equals(password);
    }

    @Override
    public int hashCode() {
        int result = userName.hashCode();

        result = 31 * result + password.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull User o) {
        int valueAfterComparison = o.userName.compareTo(this.userName);

        if (valueAfterComparison == 0) {
            return o.password.compareTo(this.password);
        }

        return valueAfterComparison;
    }

    @Override
    public String toString() {
        Map<String, ?> characteristics = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(characteristics, "User [");
    }
}
