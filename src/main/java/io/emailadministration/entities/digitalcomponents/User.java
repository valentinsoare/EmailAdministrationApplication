package io.emailadministration.entities.digitalcomponents;

import io.emailadministration.entities.companyemployees.employeedefinitionwithdetails.Employee;
import io.emailadministration.printing.CustomPrinting;
import io.emailadministration.customdatastructureandoperationsonthem.operationswithdatastructures.OperationsOnMap;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Getter
@Setter
@BatchSize(size = 16)
@Entity(name = "user")
@Table(name = "user", schema = "user")
public class User implements Comparable<User> {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(mappedBy = "user")
    private Employee employeeProfile;

    @Column(name = "user_name")
    private String userName;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "user_password", unique = true)
    private Password password;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REFRESH})
    @JoinColumn(name = "user_email", unique = true)
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

    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        Map<String, ?> characteristics = OperationsOnMap.putObjectAttributes(this);
        return CustomPrinting.of(characteristics, "User [");
    }
}
