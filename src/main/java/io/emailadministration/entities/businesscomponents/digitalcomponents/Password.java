package io.emailadministration.entities.businesscomponents.digitalcomponents;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.tuple.Pair;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyGroup;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@BatchSize(size = 8)
@Entity(name = "Password")
@Table(name = "Password", schema = "Password")
public class Password implements Comparable<Password> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @LazyGroup("PASSWORD_USER_INFO")
    @OneToOne(mappedBy = "password")
    private User user;


    @LazyGroup("PASSWORD_USER_INFO")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "mandatory_password_length_for_user")
    Pair<Integer, Integer> mandatoryPasswordLengthForUser;

    @LazyGroup("PASSWORD_USER_INFO")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "hashed_password_for_user")
    private String hashedPasswordForUser;


    @LazyGroup("PASSWORD_EMAIL_INFO")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "mandatory_password_length_for_email")
    Pair<Integer, Integer> mandatoryPasswordLengthForEmail;

    @LazyGroup("PASSWORD_EMAIL_INFO")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "hashed_password_for_email")
    private String hashedPasswordForEmail;


    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    public Password() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Password password)) return false;

        return ((password.hashedPasswordForUser.equals(hashedPasswordForUser)) &&
                (password.hashedPasswordForEmail.equals(hashedPasswordForEmail)));
    }

    @Override
    public int hashCode() {
        int result = mandatoryPasswordLengthForUser.hashCode();

        result = 31 * result + hashedPasswordForUser.hashCode();
        result = 31 * result + mandatoryPasswordLengthForEmail.hashCode();
        result = 31 * result + hashedPasswordForEmail.hashCode();

        return result;
    }

    @Override
    public int compareTo(@NotNull Password o) {
        int valueAfterComparison = o.hashedPasswordForUser.compareTo(hashedPasswordForUser);

        if (valueAfterComparison == 0) {
            return o.hashedPasswordForEmail.compareTo(hashedPasswordForEmail);
        }

        return valueAfterComparison;
    }

    @Override
    public String toString() {
        return String.format("Password [ HashedUserPassword: %s, HashedEmailPassword: %s ]",
                hashedPasswordForUser, hashedPasswordForEmail);
    }
}
