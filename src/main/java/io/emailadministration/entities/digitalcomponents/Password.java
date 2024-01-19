package io.emailadministration.entities.digitalcomponents;

import io.emailadministration.devcomponents.Component;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.tuple.Pair;
import org.hibernate.annotations.BatchSize;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@BatchSize(size = 16)
@Entity(name = "password")
@Table(name = "password", schema = "password")
public class Password implements Comparable<Password>, Component<Password> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(mappedBy = "password")
    private User user;

    @Column(name = "mandatory_password_length_for_user")
    Pair<Integer, Integer> mandatoryPasswordLengthForUser;

    @Column(name = "hashed_password_for_user")
    private String hashedPasswordForUser;

    @Column(name = "mandatory_password_length_for_email")
    Pair<Integer, Integer> mandatoryPasswordLengthForEmail;

    @Column(name = "hashed_password_for_email")
    private String hashedPasswordForEmail;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    public Password() {}

    public Password(Password passwd) {
        this.id = passwd.getId();
        this.user = passwd.getUser();
        this.mandatoryPasswordLengthForUser = Pair.of(passwd.getMandatoryPasswordLengthForUser());
        this.hashedPasswordForUser = new String(passwd.getHashedPasswordForUser());
        this.mandatoryPasswordLengthForEmail = Pair.of(passwd.getMandatoryPasswordLengthForEmail());
        this.hashedPasswordForEmail = new String(passwd.getHashedPasswordForEmail());
        this.version = passwd.getVersion();
    }

    public String hashedPasswordForUser(String password) {
        int result = 31 * password.hashCode();
        this.hashedPasswordForUser = String.valueOf(result);

        return hashedPasswordForUser;
    }

    public String hashedPasswordForEmail(String password) {
        int result = 13 * password.hashCode();
        this.hashedPasswordForEmail = String.valueOf(result);

        return hashedPasswordForEmail;
    }

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

    public Password getCopyInstance(Password password) {
        return new Password(password);
    }

    @Override
    public String getTypeOfObject() {
        return this.getClass().getSimpleName();
    }
}
