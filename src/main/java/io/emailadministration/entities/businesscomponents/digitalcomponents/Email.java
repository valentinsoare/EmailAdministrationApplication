package io.emailadministration.entities.businesscomponents.digitalcomponents;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

@Getter
@Setter
@BatchSize(size = 8)
@Entity(name = "Email")
@Table(name = "Email", schema = "Email")
public class Email implements Comparable<Email> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @LazyGroup("EMAIL_INFO_FIRST_WAVE")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @LazyGroup("EMAIL_INFO_FIRST_WAVE")
    @Column(name = "primary_email_address")
    @Basic(fetch = FetchType.LAZY)
    private String primaryEmailAddress;

    @LazyGroup("EMAIL_INFO_FIRST_WAVE")
    @Column(name = "secondary_email_address")
    @Basic(fetch = FetchType.LAZY)
    private String secondaryEmailAddress;

    @LazyGroup("EMAIL_INFO_FIRST_WAVE")
    @Column(name = "mail_box_capacity")
    @Basic(fetch = FetchType.LAZY)
    private BigDecimal mailBoxCapacity;


    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    public Email() {}

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
    public String toString() {
        return String.format("Email [primaryAddress: %s, secondaryAddress: %s, mailBoxCapacity: %s]",
                primaryEmailAddress, secondaryEmailAddress, mailBoxCapacity);
    }
}
