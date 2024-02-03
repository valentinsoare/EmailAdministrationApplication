package io.emailadministration.entities.digitalcomponents;

import io.emailadministration.devcomponents.Component;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

@Getter
@Setter
@BatchSize(size = 16)
@Entity(name = "email")
@Table(name = "email", schema = "email")
public class Email implements Comparable<Email>, Component<Email> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(mappedBy = "email")
    private User user;

    @Column(name = "primary_email_address")
    private String primaryEmailAddress;

    @Column(name = "secondary_email_address")
    private String secondaryEmailAddress;

    @Column(name = "mail_box_capacity")
    private BigDecimal mailBoxCapacity;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    public Email() {}

    public Email(Email email) {
        this.user.getCopyInstance(email.getUser());
        this.primaryEmailAddress = new String(email.getPrimaryEmailAddress());
        this.secondaryEmailAddress = new String(email.getSecondaryEmailAddress());
        this.mailBoxCapacity = new BigDecimal(String.valueOf(email.getMailBoxCapacity()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email email)) return false;

        return (email.primaryEmailAddress.equals(primaryEmailAddress));
    }

    @Override
    public int hashCode() {
        int result = primaryEmailAddress.hashCode();
        result = 31 * result + secondaryEmailAddress.hashCode();
        result = 31 * result + mailBoxCapacity.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull Email o) {
        return o.primaryEmailAddress.compareTo(this.primaryEmailAddress);
    }

    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Email getPresentObject() {
        return this;
    }

    public Email getCopyInstance(Email object) {
        Email email = new Email(object);

        email.setId(object.getId());
        email.setVersion(object.getVersion());

        return email;
    }

    @Override
    public String toString() {
        return String.format("Email [primaryAddress: %s, secondaryAddress: %s, mailBoxCapacity: %s]",
                primaryEmailAddress, secondaryEmailAddress, mailBoxCapacity);
    }
}
