package io.emailadministration.entities.digitalcomponents;

import org.apache.commons.lang3.tuple.Pair;

public class PasswordBuilder {

    private Password password;

    public PasswordBuilder(User user) {
        this.password = user.getPassword();
    }

    public PasswordBuilder setupPasswordLengthForUser(Pair<Integer, Integer> lengthInterval) {
        password.setMandatoryPasswordLengthForUser(lengthInterval);
        return this;
    }

    public PasswordBuilder setupPasswordLengthForEmail(Pair<Integer, Integer> lengthInterval) {
        password.setMandatoryPasswordLengthForEmail(lengthInterval);
        return this;
    }

    public PasswordBuilder setupPasswordForUser(String passwordForUser) {
        password.hashedPasswordForUser(passwordForUser);
        return this;
    }

    public PasswordBuilder setupPasswordForEmail(String passwordForEmail) {
        password.setHashedPasswordForEmail(passwordForEmail);
        return this;
    }
}
